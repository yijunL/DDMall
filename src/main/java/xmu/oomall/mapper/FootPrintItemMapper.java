package xmu.oomall.mapper;

import xmu.oomall.domain.FootprintItem;

public interface FootPrintItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FootprintItem record);

    int insertSelective(FootprintItem record);

    FootprintItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FootprintItem record);

    int updateByPrimaryKey(FootprintItem record);
}