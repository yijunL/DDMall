package xmu.oomall.mapper;

import xmu.oomall.domain.DefaultPieceFreight;

public interface DefaultPieceFreightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DefaultPieceFreight record);

    int insertSelective(DefaultPieceFreight record);

    DefaultPieceFreight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DefaultPieceFreight record);

    int updateByPrimaryKey(DefaultPieceFreight record);
}