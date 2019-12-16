package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;import xmu.oomall.domain.FootprintItemPo;import java.util.List;

public interface FootprintMapper {
    /**
     * 用户获取足迹列表
     *
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> select();

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return 1 or 0
     */
    int deleteByUserId(Integer id);

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> selectByCondition(@Param("userId") String userId, @Param("goodsId") String goodsId);
}