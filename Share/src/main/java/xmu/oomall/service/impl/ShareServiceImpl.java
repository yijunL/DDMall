package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


    @Override
    public ShareRulePo getShareRuleById(Integer id) {
        return shareRuleDao.getShareRuleById(id);
    }

    @Override
    public Object addShareRule(ShareRulePo sharerulePo) {
        return shareRuleDao.addShareRule(sharerulePo);
    }




    @Override
    public boolean deleteShareRuleById(Integer id) {

        return shareRuleDao.deleteShareRuleById(id);
    }

    @Override
    public Object updateShareRule(ShareRulePo sharerulePo, Integer id) {
        return shareRuleDao.updateShareRule(sharerulePo,id);
    }


    @Override
    public Object addBeSharedItems(BeSharedItem beSharedItem)
    {
        boolean a=true;//
        if(!a)
            return null;
        //用户合法性判断,分享者和被分享者
        if(!true||!true)
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
