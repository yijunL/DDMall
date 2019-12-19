package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.SpecialFreight;

import java.util.List;

public interface OomallSpecialFreightMapper {
    List<SpecialFreight> findAllByBeDeletedLessThan(@Param("maxBeDeleted")Integer maxBeDeleted);
    SpecialFreight findAllById(@Param("id")Integer id);
    int updateById(@Param("updated")SpecialFreight updated,@Param("id")Integer id);


    int insertSelective(SpecialFreight specialFreight);









}