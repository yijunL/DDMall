package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;
import xmu.oomall.service.FootprintService;
import xmu.oomall.util.ResponseUtil;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintController
 * @create 2019/12/14 13:30
 */

@RestController
@RequestMapping("footprints") //!!
public class FootprintController {
    private static final Logger logger = LoggerFactory.getLogger(FootprintController.class);

    @Autowired
    private  FootprintService footprintService;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    @GetMapping("/footprints")
    public Object listFootprintsByUserId(@RequestParam Integer page,
                                         @RequestParam Integer limit) {
        return null;
    }

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    @DeleteMapping("/footprints/{id}")
    public Object deleteFootprintById (@PathVariable Integer id) {
        if(id==null) {
            return ResponseUtil.badArgument();
        } else {
            if(footprintService.deleteFootprintById(id) == 0){
                return ResponseUtil.badArgumentValue();
            } else{
                return ResponseUtil.ok();
            }
        }
    }

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItem>
     */
    @GetMapping("/admin/footprints")
    public Object listFootprintsByCondition() {
        return null;
    }

    /**
     * 内部接口：提供给Goods模块，增加足迹
     *
     * @param
     */
    @PostMapping("/footprints")
    public Object addFootprint(@PathVariable Integer userId, @RequestBody FootprintItemPo footprintItemPo) {
        if(userId == null || footprintItemPo == null) return null; //返回响应值
        return footprintService.addFootprint(userId, footprintItemPo);
    }
}
