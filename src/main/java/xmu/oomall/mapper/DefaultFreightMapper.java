package xmu.oomall.mapper;

import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DefaultFreightMapper {
    List<DefaultFreightPo> getDefaultFreights();

    int deleteByPrimaryKey(Long id);

    int insert(DefaultFreight record);

    int insertSelective(DefaultFreight record);

    DefaultFreight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DefaultFreight record);

    int updateByPrimaryKey(DefaultFreight record);
}