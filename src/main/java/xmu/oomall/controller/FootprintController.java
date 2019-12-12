package xmu.oomall.controller;

import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

public class FootprintController {

    /**
     * 获取足迹信息/list
     */
    @GetMapping("/footprints")
    public Object list(String userId, String goodsId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order) {
        return null;
    }
//                       @Sort @RequestParam(defaultValue = "add_time") String sort,
//                      @Order @RequestParam(defaultValue = "desc") String order;

    /**
     * 删除用户足迹/delete
     *
     * @param userId 用户ID
     * @param body   请求内容， { id: xxx }
     * @return 删除操作结果
     */
    @DeleteMapping("{id}")
    public Object delete(@LoginUser Integer userId, @RequestBody String body) {
        return null;
    }

    /**
     * 获取用户足迹列表/list
     *
     * @param page  分页页数
     * @param limit 分页大小
     * @return 用户足迹列表
     */
    @GetMapping("")
    public Object list(@LoginUser Integer userId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {
        return null;
    }

    /**
     * 内部接口:添加足迹信息/add
     *
     * @param userId 用户ID
     * @param body
     */
    @PostMapping("/footprints")
    public Object add(@LoginUser Integer userId, @RequestBody FootprintItem footprint) {
        return null;
    }

}
