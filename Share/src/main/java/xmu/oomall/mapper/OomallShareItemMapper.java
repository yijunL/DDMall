package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import xmu.oomall.domain.ShareItem;


/**
 * @Author 24320172203121
 *
 */

public interface OomallShareItemMapper {
    /**
     * 找到分享商品表
     * @param goodsId
     * @param  userId
     * @param  goodsId
     * * @return List<ShareItem>
     */

    List<ShareItem> findByGoodsIdAndUserId(@Param("goodsId") Integer goodsId, @Param("userId") Integer userId);

    /**
     * 插入分享商品表
     * @param shareItem
     * * @return int
     */
    int insertSelective(ShareItem shareItem);

    /**
     * 更新分享商品表
     * @param updated
     * @param  id
     * * @return int
     */
    int updateById(@Param("updated") ShareItem updated, @Param("id") Integer id);
    /**
     * delete分享商品表
     * @param updated
     * @param  id
     * * @return int
     */

    int deleteById(@Param("id") Integer id, @Param("updated") ShareItem updated);







}