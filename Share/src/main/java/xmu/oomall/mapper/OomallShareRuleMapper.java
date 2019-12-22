package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import sun.util.resources.da.CalendarData_da;
import xmu.oomall.domain.ShareRulePo;

public interface OomallShareRuleMapper {


    ShareRulePo findByGoodsId(@Param("goodsId") Integer goodsId);

    boolean deleteById(@Param("id") Integer id);

    int insertSelective(ShareRulePo shareRulePo);



    int updateById(@Param("updated") ShareRulePo updated, @Param("id") Integer id);


    ShareRulePo findById(@Param("id") Integer id);


}