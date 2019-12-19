package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.DefaultPieceFreightPo;

import java.util.List;

public interface OomallDefaultPieceFreightMapper {

    List<DefaultPieceFreightPo> findAllByBeDeletedLessThan(@Param("maxBeDeleted") Integer maxBeDeleted);
    int insertSelective(DefaultPieceFreightPo defaultPieceFreightPo);
    int updateById(@Param("updated")DefaultPieceFreightPo updated,@Param("id")Integer id);


}