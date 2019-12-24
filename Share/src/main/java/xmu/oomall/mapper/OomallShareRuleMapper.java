package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import sun.util.resources.da.CalendarData_da;
import xmu.oomall.domain.ShareRulePo;


/**
 * @Author 24320172203121
 *
 */

public interface OomallShareRuleMapper {

    /**
     * 通过goodsid获取分享规则
     * @param goodsId
     * @return ShareRulePo
     */
    ShareRulePo findByGoodsId(@Param("goodsId") Integer goodsId);


    /**
     * 通过分享规则id删除分享规则

     * @param id
     * @return boolean
     */

    boolean deleteById(@Param("id") Integer id);
    /**
     * 增加分享规则

     * @param shareRulePo
     * @return ShareRulePo
     */
    int insertSelective(ShareRulePo shareRulePo);

    /**
     * 更新分享规则
     * @param updated
     * @param id
     * @return int
     */

    int updateById(@Param("updated") ShareRulePo updated, @Param("id") Integer id);

    /**
     * 通过id获取分享规则
     * @param id
     * @return ShareRulePo
     */
    ShareRulePo findById(@Param("id") Integer id);


}