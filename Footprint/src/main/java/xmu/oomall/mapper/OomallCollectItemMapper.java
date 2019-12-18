package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.CollectItemPo;

import java.util.List;

public interface OomallCollectItemMapper {
    List<CollectItemPo> findAllById(@Param("id") Integer id);
    int insertSelective(CollectItemPo collectItemPo);




    boolean deleteById(@Param("id") Integer id);


}