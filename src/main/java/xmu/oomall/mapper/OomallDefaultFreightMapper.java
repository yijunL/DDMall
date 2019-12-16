package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;import xmu.oomall.domain.DefaultFreightPo;import java.util.List;

public interface OomallDefaultFreightMapper {
    boolean deleteDefaultFreight(Integer id);

    DefaultFreightPo findAllById(@Param("id") Integer id);

    List<DefaultFreightPo> findAllByBeDeletedLessThan(@Param("maxBeDeleted") Integer maxBeDeleted);
}