package xmu.oomall.service;

import xmu.oomall.domain.Order;
import org.springframework.stereotype.Service;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareRulePo;

@Service
public interface ShareService {
    ShareRulePo getShareRuleById(Integer id);

    Object addShareRule(ShareRulePo sharerulePo) throws Exception;

    boolean deleteShareRuleById(Integer id);

    Object updateShareRule(ShareRulePo sharerulePo, Integer id) throws Exception;

    Object addBeSharedItems(BeSharedItem beSharedItem);

    Integer getRebate(Order order);
}
