package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.FootprintDAO;
import xmu.oomall.domain.*;
import xmu.oomall.service.FootprintService;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintController
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
     * @return List<FootprintItem>
     */
    @Override
    public Object listFootprintByCondition(Integer page, Integer limit) {
        return null;
    }

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    @Override
    public Object deleteFootprintById (Integer id) {
        return null;
    }

    /**
     * 用户删除足迹
     *
     * @return List<FootprintItem>
     */
    @Override
    public Object listFootprint() {
        return null;
    }
}
