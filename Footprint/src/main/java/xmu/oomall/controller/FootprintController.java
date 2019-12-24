package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.AddLog;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.domain.Log;
import xmu.oomall.service.FootprintService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintController
 * @create 2019/12/14 13:30
 */

@RestController
@RequestMapping(value = "")
public class FootprintController {

    @Autowired
    private  FootprintService footprintService;
    @Autowired
    private AddLog addLog;

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
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if (page == null || limit == null
            || page <= 0 || limit <= 0) {
            return ResponseUtil.fail(742, "足迹查询失败");
        }
        else {
            List<FootprintItem> footprintItems = footprintService.listFootprintsByUserId(userId, page, limit);
            if (footprintItems == null) {
                return ResponseUtil.fail(742, "足迹查询失败");
            }
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
    public Object deleteFootprintById (HttpServletRequest request, @PathVariable Integer id) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }

        if (id == null) {
            return ResponseUtil.fail(740,"该足迹是无效足迹（不在数据库里的或者逻辑删除） ");
        } else {
            if (footprintService.deleteFootprintById(id) == 0) {
                return ResponseUtil.fail(740,"该足迹是无效足迹（不在数据库里的或者逻辑删除） ");
            } else {
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
    public Object listFootprintsByCondition(HttpServletRequest request, @RequestParam Integer userId, @RequestParam Integer goodsId,
                                                 @RequestParam Integer page, @RequestParam Integer limit) throws UnknownHostException {
        Integer adminId = getUserId(request);
        if (adminId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }
        Log log = new Log();
        log.setAdminId(adminId);
        log.setActionId(userId);
        log.setActions("查看某一用户的足迹列表");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(0);
        log.setIp(InetAddress.getLocalHost().toString());

        if (page == null || limit == null
                || page <= 0 || limit <= 0) {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(742, "足迹查询失败");
        } else {
            List<FootprintItem> footprintItemList = footprintService.listFootprintsByCondition(userId, goodsId, page, limit);
            if(footprintItemList == null) {
                log.setStatusCode(0);
                addLog.addLog(log);
                return ResponseUtil.fail(742, "足迹查询失败");
            }
            log.setStatusCode(1);
            addLog.addLog(log);
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
    public Object addFootprint(HttpServletRequest request, @RequestBody FootprintItemPo footprintItemPo) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if (footprintItemPo == null) {
            return ResponseUtil.fail(741, "足迹添加失败");
        } else {
            FootprintItemPo footprintItemPo1 = footprintService.addFootprint(footprintItemPo);
            if(footprintItemPo1 == null) {
                return ResponseUtil.fail(741, "足迹添加失败");
            } else {
                return ResponseUtil.ok(footprintItemPo);
            }
        }
    }
}
