package xmu.oomall.service;

import xmu.oomall.domain.Order;
import org.springframework.stereotype.Service;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareRulePo;

@Service
public interface ShareService {

    /**
    获取分享规则通过GoodsID
     */
    ShareRulePo getShareRuleById(Integer id);

    /**
     增添分享规则
     */
    Object addShareRule(ShareRulePo sharerulePo) throws Exception;
    /**
     删除分享规则
     */
    boolean deleteShareRuleById(Integer id);
    /**
     修改分享规则
     */
    Object updateShareRule(ShareRulePo sharerulePo, Integer id) throws Exception;
    /**
     增添被分享表
     */
    Object addBeSharedItems(BeSharedItem beSharedItem);
    /**
     获取返点
     */
    Integer getRebate(Order order);
}
