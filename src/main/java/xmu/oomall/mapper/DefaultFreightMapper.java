package xmu.oomall.mapper;

import xmu.oomall.domain.DefaultFreightPo;

public interface DefaultFreightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DefaultFreightPo record);

    int insertSelective(DefaultFreightPo record);

    DefaultFreightPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DefaultFreightPo record);

    int updateByPrimaryKey(DefaultFreightPo record);
}