package xmu.oomall.mapper;
import java.util.List;

import com.mysql.cj.xdevapi.InsertStatement;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.BeSharedItem;


/**
 * @Author 24320172203121
 *
 */

public interface OomallBeSharedItemMapper {

    /**
     * 插入被分享商品表
     * @param beSharedItem
     * * @return int
     */

    int insertSelective(BeSharedItem beSharedItem);
    /**
     * 找到被分享商品表
     * @param goodsId
     * @param  beSharedUserId
     * @param  sharerId
     * * @return BeSharedItem
     */

    BeSharedItem findByGoodsIdAndBeSharedUserIdAndSharerId(@Param("goodsId") Integer goodsId, @Param("beSharedUserId") Integer beSharedUserId, @Param("sharerId") Integer sharerId);

    /**
     * 找到被分享商品表
     * @param goodsId
     * @param  beSharedUserId
     * * @return BeSharedItem
     */
    BeSharedItem findByGoodsIdAndBeSharedUserId(@Param("goodsId") Integer goodsId, @Param("beSharedUserId") Integer beSharedUserId);

    /**
     * 更新被分享商品表
     * @param updated
     * @param  id
     * * @return int
     */
     int updateById(@Param("updated") BeSharedItem updated, @Param("id") Integer id);




}