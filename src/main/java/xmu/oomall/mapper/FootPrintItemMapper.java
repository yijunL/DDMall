package xmu.oomall.mapper;

import xmu.oomall.dao.FootPrintItem;

public interface FootPrintItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FootPrintItem record);

    int insertSelective(FootPrintItem record);

    FootPrintItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FootPrintItem record);

    int updateByPrimaryKey(FootPrintItem record);
}