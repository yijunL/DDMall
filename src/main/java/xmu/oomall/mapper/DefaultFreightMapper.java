package xmu.oomall.mapper;

import xmu.oomall.dao.DefaultFreight;

public interface DefaultFreightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DefaultFreight record);

    int insertSelective(DefaultFreight record);

    DefaultFreight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DefaultFreight record);

    int updateByPrimaryKey(DefaultFreight record);
}