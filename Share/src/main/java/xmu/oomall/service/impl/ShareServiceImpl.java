package xmu.oomall.service.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.AddGoods;
import xmu.oomall.AddUser;
import xmu.oomall.controller.ShareController;
import xmu.oomall.dao.BeSharedItemDao;
import xmu.oomall.dao.ShareItemDao;
import xmu.oomall.dao.ShareRuleDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.ShareService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShareServiceImpl extends ShareController implements ShareService {

    @Autowired
    private BeSharedItemDao beSharedItemDao;

    @Autowired
    private ShareRuleDao shareRuleDao;

    @Autowired
    private ShareItemDao shareItemDao;
  //调用用户微服务
    @Autowired
    private AddUser addUser;
    //调用商品微服务
    @Autowired
    private AddGoods addGoods;

    /**
     获取分享规则，通过GoodsID
     */

    @Override
    public ShareRulePo getShareRuleById(Integer id) {
        return shareRuleDao.getShareRuleById(id);
    }


    /**
     判断分享规则是否正确，合法性检查，检查strategy是否合法
     */

    public boolean beValiedShareRule(ShareRulePo shareRulePo)throws Exception
    {
        int type =0;
        int[] lowerbound;
        int[] upperbound;
        double[] rate;
        try {
            //JSON格式合法性检查
            String strategyLevel = shareRulePo.getShareLevelStrategy();
            JSONObject jsonObject = JSONObject.fromObject(strategyLevel);
            type = jsonObject.getInt("type");
            JSONArray strategys = jsonObject.getJSONArray("strategy");
            lowerbound = new int[strategys.size()];
            upperbound = new int[strategys.size()];
            rate = new double[strategys.size()];
            for (int i = 0; i < strategys.size(); i++) {
                JSONObject strategy = strategys.getJSONObject(i);
                lowerbound[i] = strategy.getInt("lowerbound");
                upperbound[i] = strategy.getInt("upperbound");
                //JSON 数值合法性检查
                if(lowerbound[i]<=0||upperbound[i]<=0)
                    return false;
                if(lowerbound[i]>upperbound[i])
                    return false;
                if(i>=1)
                    if(lowerbound[i]<=upperbound[i-1]||upperbound[i]<=upperbound[i-1])
                        return false;
                rate[i] = strategy.getDouble("rate");
                if(rate[i]<0)
                    return false;
                if(i>=1)
                    if(rate[i]<rate[i-1])
                        return false;
            }
            if(type!=0&&type!=1)
                return  false;


        }catch (Exception e)
        {
            return false;
        }
        return true;
    }

    /**
     增添分享规则
     */
    @Override
    public Object addShareRule(ShareRulePo sharerulePo) throws Exception {

        if(beValiedShareRule(sharerulePo))
        return shareRuleDao.addShareRule(sharerulePo);
        else return null;
    }



    /**
     删除分享规则
     */
    @Override
    public boolean deleteShareRuleById(Integer id) {

        return shareRuleDao.deleteShareRuleById(id);
    }

    /**
     修改分享规则
     */
    @Override
    public Object updateShareRule(ShareRulePo sharerulePo, Integer id) throws Exception {

        boolean b=beValiedShareRule(sharerulePo);
        if(b)
        return shareRuleDao.updateShareRule(sharerulePo,id);
        else return false;
    }


    /**
     增添被分享表
     */
    @Override
    public Object addBeSharedItems(BeSharedItem beSharedItem)
    {
        //商品上下架判断
        boolean a=true;
        a=addGoods.isOnsale(beSharedItem.getGoodsId());
        if(!a)
            return null;
        //用户合法性判断,分享者和被分享者
        boolean b=true;
        boolean c=true;
        b=addUser.beValidate(beSharedItem.getSharerId());
        c=addUser.beValidate(beSharedItem.getBeSharedUserId());
        if(!b||!c)
            return null;
        return beSharedItemDao.addBeSharedItems(beSharedItem);
    }


    /**
     获取返点
     */
    @Override
    public Integer getRebate(Order order) {
        Integer beSharedUserId=order.getUserId();
        List<OrderItem> orderItemList=order.getOrderItemList();

        //获取订单中有效的分享商品

        List<BeSharedItem> beSharedItemList= beSharedItemDao.getValidBeShareItem(beSharedUserId,orderItemList);

       //无有效分享商品，返点0
        if(beSharedItemList==null) return 0;
        //获取商品价格
        BigDecimal price = new BigDecimal(0);
        for(OrderItem orderItem:orderItemList)
        { if(orderItem.getGoodsId()==beSharedItemList.get(0).getGoodsId())
          price=orderItem.getPrice();break; }

        //更新sucessnum和计算返点
        return shareItemDao.updateShareItemSuccessNumAndCalculate(beSharedItemList,price);

    }
}
