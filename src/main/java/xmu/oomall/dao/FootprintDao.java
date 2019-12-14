package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.*;
import xmu.oomall.mapper.FootprintMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintDAO
 * @create 2019/12/14 13:30
 */
@Repository
public class FootprintDao {
    @Autowired
    private FootprintMapper footprintMapper;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItemPo>
     */
    public List<FootprintItemPo> selectByCondition(Integer page, Integer limit) {
        List<FootprintItemPo> footprintItemPos = footprintMapper.selectByCondition(page, limit);
        return footprintItemPos;
    }

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    public boolean deleteFootprintById (Integer id) {
        return (footprintMapper.deleteByUserId(id) == 1);
    }

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItemPo>
     */
    public List<FootprintItemPo> selectAll() {
        List<FootprintItemPo> footprintItemPos = footprintMapper.selectAll();
        return footprintItemPos;
    }
}
