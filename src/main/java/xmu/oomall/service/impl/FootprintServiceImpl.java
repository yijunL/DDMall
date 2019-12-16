package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.FootprintDao;
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
    @Autowired
    FootprintDao footprintDao;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    @Override
    public List<FootprintItem> listFootprintsByUserId(Integer page, Integer limit) {
        List<FootprintItem> footprintItems = footprintDao.selectByUserId(page, limit);
        return footprintItems;
    }

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    @Override
    public Boolean deleteFootprintById (Integer id) {
        return footprintDao.deleteFootprintById(id);
    }

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItem>
     */
    @Override
    public List<FootprintItem> listFootprintsByCondition() {
        List<FootprintItem> footprintItems = footprintDao.selectByCondition();
        return footprintItems;
    }

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param userId: Integer
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    @Override
    public FootprintItemPo addFootprint(Integer userId, FootprintItemPo footprintItemPo) {
        return footprintDao.addFootprint(userId, footprintItemPo);
    }
}
