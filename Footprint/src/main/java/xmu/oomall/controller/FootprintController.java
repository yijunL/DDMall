package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.service.FootprintService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
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
     * 解析请求
     * @param request
     * @return userId
     */
    private Integer getUserId(HttpServletRequest request) {
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null) {
            return null;
        }
        return Integer.valueOf(userIdStr);
    }

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    @GetMapping("/footprints")
    public Object listFootprintsByUserId(HttpServletRequest request,
                                         @RequestParam Integer page,
                                         @RequestParam Integer limit) {
        Integer userId = getUserId(request); //从网关获取用户id
        if (userId == null) { //可能不需要该判断
            return ResponseUtil.unlogin(); //是否返回别的值？
        }
        if (page == null || limit == null
            || page < 0 || limit < 0) {
            return ResponseUtil.fail(742, "足迹查询失败");
        }
        else {
            List<FootprintItem> footprintItems = footprintService.listFootprintsByUserId(userId, page, limit);
            return ResponseUtil.ok(footprintItems);
        }
    }

    /**
     * 用户删除足迹（弃用）
     *
     * @param id：Integer
     * @return Response.ok()
     */
    @DeleteMapping("/footprints/{id}")
    public Object deleteFootprintById (@PathVariable Integer id) {
        if(id == null) {
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
     * @param userId: Integer
     * @param goodsId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<FootprintItem>
     */
    @GetMapping("/admin/footprints")
    public Object listFootprintsByCondition(@RequestParam Integer userId, @RequestParam Integer goodsId,
                                            @RequestParam Integer page, @RequestParam Integer limit) {
        if(page == null || limit == null
            || page < 0 || limit < 0) {
            return ResponseUtil.fail(742, "足迹查询失败");
        } else {
            List<FootprintItem> footprintItemList = footprintService.listFootprintsByCondition(userId, goodsId, page, limit);
            //是否判断返回值是否为0？
            //System.out.println(footprintItemList.size()); //!!Test
            return ResponseUtil.ok(footprintItemList);
        }
    }

    /**
     * 内部接口：提供给Goods模块，增加足迹
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    @PostMapping("/footprints")
    public Object addFootprint(@RequestBody FootprintItemPo footprintItemPo) {
        if(footprintItemPo == null) {
            return ResponseUtil.fail(741, "足迹添加失败"); //返回响应值
        } else { //是否需要进一步判断userId?
            FootprintItemPo footprintItemPo1 = footprintService.addFootprint(footprintItemPo);
            if(footprintItemPo1 == null) {
                return ResponseUtil.fail(741, "足迹添加失败");
            } else {
                return ResponseUtil.ok(footprintItemPo);
            }
        }
    }
}