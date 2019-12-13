package xmu.oomall.mapper;

import xmu.oomall.domain.DefaultPieceFreightPo;

public interface DefaultPieceFreightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DefaultPieceFreightPo record);

    int insertSelective(DefaultPieceFreightPo record);

    DefaultPieceFreightPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DefaultPieceFreightPo record);

    int updateByPrimaryKey(DefaultPieceFreightPo record);
}