package xmu.oomall.mapper;
import xmu.oomall.domain.CollectItemPo;
import org.apache.ibatis.annotations.Param;

public interface OomallCollectItemMapper {
    CollectItemPo findAllById(@Param("id")Integer id);

    int deleteById(@Param("id")Integer id);


}