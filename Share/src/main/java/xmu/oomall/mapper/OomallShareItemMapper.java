package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import xmu.oomall.domain.ShareItem;

public interface OomallShareItemMapper {
    List<ShareItem> findByGoodsIdAndUserId(@Param("goodsId") Integer goodsId, @Param("userId") Integer userId);

    int insertSelective(ShareItem shareItem);

    int updateById(@Param("updated") ShareItem updated, @Param("id") Integer id);

    int deleteById(@Param("id") Integer id, @Param("updated") ShareItem updated);







}