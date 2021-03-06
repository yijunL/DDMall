package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.UserValidate;
import xmu.oomall.dao.FootprintDao;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
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
    @Autowired
    private UserValidate userValidate;

    /**
     * 用户获取足迹列表
     *
     * @param userId: Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    @Override
    public List<FootprintItem> listFootprintsByUserId(Integer userId, Integer page, Integer limit) {
        if (!userValidate.validate(userId)) {
            return null;
        }
        List<FootprintItem> footprintItems = footprintDao.selectByUserId(userId, page, limit);
        return footprintItems;
    }

    /**
     * 用户删除足迹（弃用）
     *
     * @param id：Integer
     * @return Response.ok()
     */
    @Override
    public int deleteFootprintById (Integer id) {
        if (footprintDao.deleteFootprintById(id) > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * 管理员查看足迹
     *
     * @param userId: Integer
     * @param goodsId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<FootprintItem>
     */
    @Override
    public List<FootprintItem> listFootprintsByCondition(Integer userId, Integer goodsId, Integer page, Integer limit) {
        List<FootprintItem> footprintItems = footprintDao.selectByCondition(userId, goodsId, page, limit);
        return footprintItems;
    }

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    @Override
    public FootprintItemPo addFootprint(FootprintItemPo footprintItemPo) {
        return footprintDao.addFootprint(footprintItemPo);
    }
}
