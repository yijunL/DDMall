package xmu.oomall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.controller.vo.GoodsVo;
import xmu.oomall.domain.*;
import xmu.oomall.dao.*;
import xmu.oomall.service.GoodsService;
import xmu.oomall.util.ResponseUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootprintServiceImpl {

    /**
     *获取足迹信息/list
     */
    @GetMapping("/footprints")
    public Object list(String userId, String goodsId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order);
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
    public Object delete(@LoginUser Integer userId, @RequestBody String body);

    /**
     * 获取用户足迹列表/list
     *
     * @param page 分页页数
     * @param limit 分页大小
     * @return 用户足迹列表
     */
    @GetMapping("")
    public Object list(@LoginUser Integer userId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit);

    /**
     *内部接口:添加足迹信息/add
     *@param userId 用户ID
     *@param body
     */
    @PostMapping("/footprints")
    public Object add(@LoginUser Integer userId, @RequestBody Footprint footprint);
}
