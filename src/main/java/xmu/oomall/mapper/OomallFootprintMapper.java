package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

public interface OomallFootprintMapper {
    /**
     * 用户获取足迹列表
     *
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> selectAllByUserId(@Param("userId")Integer userId);

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return 1 or 0
     */
    int deleteById(@Param("id")Integer id);

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> selectByCondition(@Param("userId") String userId, @Param("goodsId") String goodsId);

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    int insertSelective(FootprintItemPo footprintItemPo);
}