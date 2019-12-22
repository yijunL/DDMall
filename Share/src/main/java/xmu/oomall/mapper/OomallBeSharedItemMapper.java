package xmu.oomall.mapper;
import java.util.List;

import com.mysql.cj.xdevapi.InsertStatement;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.BeSharedItem;

public interface OomallBeSharedItemMapper {

    int insertSelective(BeSharedItem beSharedItem);


    BeSharedItem findByGoodsIdAndBeSharedUserIdAndSharerId(@Param("goodsId") Integer goodsId, @Param("beSharedUserId") Integer beSharedUserId, @Param("sharerId") Integer sharerId);


    BeSharedItem findByGoodsIdAndBeSharedUserId(@Param("goodsId") Integer goodsId, @Param("beSharedUserId") Integer beSharedUserId);

     int updateById(@Param("updated") BeSharedItem updated, @Param("id") Integer id);




}