package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.BeSharedItemDao;
import xmu.oomall.dao.ShareItemDao;
import xmu.oomall.dao.ShareRuleDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.ShareService;

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
    public Object addBeSharedItems(BeSharedItem beSharedItem) {
        return null;
    }

    @Override
    public Integer getRebate(Order order) {
        return null;
    }


//    @Override
//    public Object addBeSharedItems(BeSharedItem beSharedItem)
//    {
//        if(!goodsController .isGoodsOnSale(beSharedItem.getGoodsId()))
//            return null;
//        if(!userinfoController.beValid(beSharedItem.getSharerId())||
//                !userinfoController.beValid(beSharedItem.getBeSharedUserId()))
//            return null;
//        return beSharedItemDao.addBeSharedItems(beSharedItem);
//    }

//    @Override
//    public Integer getRebate(Order order) {
//        Integer beSharedUserId=order.getUserId();
//
//        List<OrderItem> orderItemList=order.getOrderItemList();
//        List<BeSharedItem> beSharedItemList= beSharedItemDao.getValidBeShareItem(beSharedUserId,orderItemList);
//        if(beSharedItemList==null) return 0;
//        shareItemDao.updateShareItemSuccessNum(beSharedItemList);
//        return shareItemDao.calculateRebate();
//    }
}
