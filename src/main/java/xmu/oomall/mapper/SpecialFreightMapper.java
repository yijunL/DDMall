package xmu.oomall.mapper;

import xmu.oomall.dao.SpecialFreight;

public interface SpecialFreightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialFreight record);

    int insertSelective(SpecialFreight record);

    SpecialFreight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialFreight record);

    int updateByPrimaryKey(SpecialFreight record);
}