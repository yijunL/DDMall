package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: OomallFootprintMapper
 * @create 2019/12/14 13:30
 */
public interface OomallFootprintMapper {

    /**
     * 用户获取足迹列表
     *
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> selectAllByUserId(@Param("userId") Integer userId);

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return 1 or 0
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 管理员查看足迹
     *
     * @param userId:  Integer
     * @param goodsId: Integer
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> selectByCondition(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);

    /**
     * 管理员按条件查询时，若条件均为null则返回全体
     *
     * @return List<FootprintItemPo>
     */
    List<FootprintItemPo> selectAll();

    /**
     * 根据id查找足迹（可判断是否已存在符合该id的足迹）
     *
     * @param id: Integer
     * @return FootprintItemPo
     */
    FootprintItemPo selectAllById(@Param("id") Integer id);

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    int insertSelective(FootprintItemPo footprintItemPo);
}