package xmu.oomall.service;

import xmu.oomall.domain.Order;
import org.springframework.stereotype.Service;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareRulePo;

/**
 * @Author 24320172203121
 *
 */
@Service
public interface ShareService {

    /**
     * 通过id获取分享规则
     * @param id
     * @return ShareRulePo
     */
    ShareRulePo getShareRuleById(Integer id);

    /**
     * 增加分享规则

     * @param sharerulePo
     * @return ShareRulePo
     * @exception Exception JSON 解析错误
     *
     */
    Object addShareRule(ShareRulePo sharerulePo) ;


    /**
     * 通过分享规则id删除分享规则
     * @param id
     * @return Boolean
     */
    boolean deleteShareRuleById(Integer id);
    /**
     * 更新分享规则
     * @param sharerulePo,id
     * @param id
     *  @exception net.sf.json.JSONException
     * @return  Object
     */
    Object updateShareRule(ShareRulePo sharerulePo, Integer id);

    /**
     * 增加被分享记录表

     * @param beSharedItem
     * @return Object
     */
    Object addBeSharedItems(BeSharedItem beSharedItem);

    /**
     * 根据订单获取返点
     * @param order
     * @return Integer
     */
    Integer getRebate(Order order);
}
