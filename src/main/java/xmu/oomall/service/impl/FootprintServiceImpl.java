package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.FootprintDAO;
import xmu.oomall.domain.*;
import xmu.oomall.service.FootprintService;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintServiceImpl
 * @create 2019/12/14 13:30
 */

@Service
public class FootprintServiceImpl implements FootprintService {
    @Autowired FootprintDAO footprintDAO;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItemPo>
     */
    @Override
    public List<FootprintItemPo> listFootprintByCondition(Integer page, Integer limit) {
        List<FootprintItemPo> footprintItemPos = footprintDAO.selectByCondition(page, limit);
        return footprintItemPos;
    }

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    @Override
    public Boolean deleteFootprintById (Integer id) {
        return footprintDAO.deleteFootprintById(id);
    }

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItemPo>
     */
    @Override
    public List<FootprintItemPo> listAllFootprint() {
        List<FootprintItemPo> footprintItemPos = footprintDAO.selectAll();
        return footprintItemPos;
    }
}
