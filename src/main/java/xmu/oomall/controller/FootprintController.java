package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;
import xmu.oomall.service.FootprintService;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintController
 * @create 2019/12/14 13:30
 */

@RestController
@RequestMapping("footprintService")
public class FootprintController {
    private static final Logger logger = LoggerFactory.getLogger(FootprintController.class);

    @Autowired
    private  FootprintService footprintService;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItemPo>
     */
    @GetMapping("/footprints")
    public Object listFootprintByCondition(@RequestParam Integer page,
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
    public Object deleteFootprintById (@RequestParam Integer id) {
        return null;
    }

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItemPo>
     */
    @GetMapping("/admin/footprints")
    public Object listAllFootprint() {
        return null;
    }
}
