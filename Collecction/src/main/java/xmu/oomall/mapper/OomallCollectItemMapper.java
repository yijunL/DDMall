package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.CollectItemPo;

import java.util.List;

/**
 * @author Lyj
 */
public interface OomallCollectItemMapper {
    /**
     * 通过id查找收藏加item
     * @param id
     * @return
     */
    List<CollectItemPo> findAllById(@Param("id") Integer id);

    /**
     * 插入一条收藏夹item记录
     * @param collectItemPo
     * @return
     */
    int insertSelective(CollectItemPo collectItemPo);

    /**
     * 通过id删除收藏item
     * @param id
     * @return
     */
    boolean deleteById(@Param("id") Integer id);
}