package xmu.oomall.mapper;

import xmu.oomall.dao.FootprintItem;

public interface FootprintItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FootprintItem record);

    int insertSelective(FootprintItem record);

    FootprintItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FootprintItem record);

    int updateByPrimaryKey(FootprintItem record);
}