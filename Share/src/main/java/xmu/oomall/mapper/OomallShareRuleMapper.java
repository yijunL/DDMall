package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import sun.util.resources.da.CalendarData_da;
import xmu.oomall.domain.ShareRulePo;

public interface OomallShareRuleMapper {


    /**
     * 通过Goodsid获取分享规则
     * @return ShareRulePo
     */
    ShareRulePo findByGoodsId(@Param("goodsId") Integer goodsId);

    /**
     * 删除分享规则

     */
    boolean deleteById(@Param("id") Integer id);


    /**
     * 插入分享规则

     */
    int insertSelective(ShareRulePo shareRulePo);


    /**
     * 删除分享规则

     */
    int updateById(@Param("updated") ShareRulePo updated, @Param("id") Integer id);


    /**
     * 获取分享规则，通过规则ID

     */

    ShareRulePo findById(@Param("id") Integer id);


}