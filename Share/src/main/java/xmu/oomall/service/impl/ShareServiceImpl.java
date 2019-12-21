package xmu.oomall.service.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.AddGoods;
import xmu.oomall.AddUser;
import xmu.oomall.dao.BeSharedItemDao;
import xmu.oomall.dao.ShareItemDao;
import xmu.oomall.dao.ShareRuleDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.ShareService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private BeSharedItemDao beSharedItemDao;
    @Autowired
    private ShareRuleDao shareRuleDao;
    @Autowired
    private ShareItemDao shareItemDao;
    @Autowired
    private AddUser addUser;

    @Autowired
    private AddGoods addGoods;

    @Override
    public ShareRulePo getShareRuleById(Integer id) {
        return shareRuleDao.getShareRuleById(id);
    }


    public boolean beValiedShareRule(ShareRulePo shareRulePo)throws Exception
    {
        int type =0;
        int[] lowerbound;
        int[] upperbound;
        double[] rate;
        try {
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

    @Override
    public Object addShareRule(ShareRulePo sharerulePo) throws Exception {

        if(beValiedShareRule(sharerulePo))
        return shareRuleDao.addShareRule(sharerulePo);
        else return null;
    }




    @Override
    public boolean deleteShareRuleById(Integer id) {

        return shareRuleDao.deleteShareRuleById(id);
    }

    @Override
    public Object updateShareRule(ShareRulePo sharerulePo, Integer id) throws Exception {

        if(beValiedShareRule(sharerulePo))
        return shareRuleDao.updateShareRule(sharerulePo,id);
        else return false;
    }


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

    @Override
    public Integer getRebate(Order order) {
        Integer beSharedUserId=order.getUserId();


        List<OrderItem> orderItemList=order.getOrderItemList();
        List<BeSharedItem> beSharedItemList= beSharedItemDao.getValidBeShareItem(beSharedUserId,orderItemList);
        if(beSharedItemList==null) return 0;
        BigDecimal price = new BigDecimal(0);
        for(OrderItem orderItem:orderItemList)
        { if(orderItem.getGoodsId()==beSharedItemList.get(0).getGoodsId())
          price=orderItem.getPrice();break; }

        return shareItemDao.updateShareItemSuccessNumAndCalculate(beSharedItemList,price);

    }
}
