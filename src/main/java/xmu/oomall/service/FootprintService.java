package xmu.oomall.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;

import java.util.List;

/**
 * @Author zhc
 * @create 2019/12/3 18:30
 */

@Service
public interface FootprintService {
    /**
     * 获取足迹信息/list
     */
    public Object list(String userId, String goodsId, Integer page, Integer limit, String sort, String order);

    /**
     * 删除用户足迹/delete
     *
     * @param userId 用户ID
     * @param body   请求内容， { id: xxx }
     * @return 删除操作结果
     */
    public Object delete(Integer userId, String body);

    /**
     * 获取用户足迹列表/list
     *
     * @param page  分页页数
     * @param limit 分页大小
     * @return 用户足迹列表
     */
    public Object list(Integer userId, Integer page, Integer limit);

    /**
     * 内部接口:添加足迹信息/add
     *
     * @param userId 用户ID
     * @param body
     */
    public Object add(Integer userId, FootprintItem footprint);
}
