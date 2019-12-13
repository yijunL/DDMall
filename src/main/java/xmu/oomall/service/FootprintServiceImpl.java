package xmu.oomall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;
import xmu.oomall.dao.*;
import xmu.oomall.dao.FootprintItem;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    private  FootprintItem footprintDAO;

    /**
     * 获取足迹信息/list
     */
    @Override
    public Object list(String userId, String goodsId, Integer page, Integer limit, String sort, String order) {
        return null;
    }

    /**
     * 删除用户足迹/delete
     *
     * @param userId 用户ID
     * @param body   请求内容， { id: xxx }
     * @return 删除操作结果
     */
    @Override
    public Object delete(Integer userId, String body) {
        return null;
    }

    /**
     * 获取用户足迹列表/list
     *
     * @param page  分页页数
     * @param limit 分页大小
     * @return 用户足迹列表
     */
    public Object list(Integer userId, Integer page, Integer limit) {
        return null;
    }

    /**
     * 内部接口:添加足迹信息/add
     *
     * @param userId 用户ID
     * @param body
     */
    public Object add(Integer userId, xmu.oomall.domain.FootprintItem footprint) {
        return null;
    }
}
