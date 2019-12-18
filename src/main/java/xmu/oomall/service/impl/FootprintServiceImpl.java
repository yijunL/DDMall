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
     * @param userId: Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    @Override
    public List<FootprintItem> listFootprintsByUserId(Integer userId, Integer page, Integer limit) {
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
        if(footprintDao.deleteFootprintById(id) > 0) { //or == 1
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
        //查询无结果，返回空列表而非null
//        for(FootprintItem footprintItem : footprintItems) { //!!Test
//            System.out.println(footprintItem.getUserId() + " and " + footprintItem.getGoodsId());
//        }
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
