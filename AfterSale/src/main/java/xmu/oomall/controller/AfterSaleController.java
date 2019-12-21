package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.AddLog;
import xmu.oomall.domain.AftersalesService;
import xmu.oomall.domain.Log;
import xmu.oomall.service.AfterSaleService;

import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Bexasusual
 * @Description: AfterSaleController
 * @create 2019/12/16 20:49
 */
@RestController
@RequestMapping("/afterSaleServices") //!!
public class AfterSaleController {

    @Autowired
    private AfterSaleService afterSaleService;

    @Autowired
    private AddLog addLog;

    /**
     * 解析用户请求
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
     * 解析管理员请求
     * @param request
     * @return id
     */
    private Integer getAdminId(HttpServletRequest request) {
        String adminIdStr = request.getHeader("userId"); //!!不确定
        if (adminIdStr == null) {
            return null;
        }
        return Integer.valueOf(adminIdStr);
    }

    /**
     * 管理员查询售后服务列表（管理员操作失败(676)与成功返回什么？）
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AftersalesService>
     */
    @GetMapping("/admin/afterSaleServices")
    public Object listAfterSalesByCondition(HttpServletRequest request, @RequestParam Integer userId, @RequestParam Integer page, @RequestParam Integer limit) throws UnknownHostException {
        Integer adminId = getAdminId(request);
        if(adminId == null) {
            return ResponseUtil.fail(669, "管理员未登录");
        }
        Log log = new Log();
        log.setAdminId(adminId);
        log.setActionId(userId);
        log.setActions("查询售后服务列表");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(0); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());
        if (userId == null) {
            log.setStatusCode(0); //操作失败
            addLog.addLog(log);
            return ResponseUtil.fail(691, "获取售后服务失败");
        }
        if (page == null || limit == null
            || page <= 0 || limit <= 0) {
            log.setStatusCode(0); //操作失败
            addLog.addLog(log);
            return ResponseUtil.fail(691, "获取售后服务失败");
        }
        List<AftersalesService> aftersalesServiceList = afterSaleService.listAfterSalesByCondition(userId, page, limit);
        if (aftersalesServiceList == null) {
            log.setStatusCode(0); //操作失败
            addLog.addLog(log);
            return ResponseUtil.fail(691, "获取售后服务失败");
        }
        log.setStatusCode(1); //操作成功
        addLog.addLog(log);
        return ResponseUtil.ok(aftersalesServiceList);
    }

    /**
     * 管理员查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AftersalesService
     */
    @GetMapping("/admin/afterSaleServices/{id}")
    public Object getAfterSaleByIdForAdmin(HttpServletRequest request, @PathVariable Integer id) throws UnknownHostException {
        Integer adminId = getAdminId(request);
        if(adminId == null) {
            return ResponseUtil.fail(669, "管理员未登录");
        }
        Log log = new Log();
        log.setAdminId(adminId);
        log.setActionId(id);
        log.setActions("查询售后服务");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(0); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());
        if (id == null) {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(691, "获取售后服务失败");
        } else {
            AftersalesService afterSaleService1 = afterSaleService.getAfterSaleByIdForAdmin(id);
            if (afterSaleService1 == null) {
                log.setStatusCode(0);
                addLog.addLog(log);
                return ResponseUtil.fail(691, "获取售后服务失败"); //
            } else {
                System.out.println("ok"); //
                log.setStatusCode(1);
                addLog.addLog(log);
                return ResponseUtil.ok(afterSaleService1);
            }
        }
    }

    /* 重复的方法——用户 */
    /**
     * 用户查询某一售后服务（用户是否必须登录才能浏览售后？）
     *
     * @param id: Integer
     * @return AftersalesService
     */
    @GetMapping("/afterSaleServices/{id}")
    public Object getAfterSaleById(HttpServletRequest request, @PathVariable Integer id) {
        if (id == null) {
            return ResponseUtil.fail(691, "获取售后服务失败");
        } else {
            AftersalesService afterSaleService1 = afterSaleService.getAfterSaleById(id);
            if (afterSaleService1 == null) {
                return ResponseUtil.fail(691, "获取售后服务失败"); //
            } else {
                System.out.println("ok"); //
                return ResponseUtil.ok(afterSaleService1);
            }
        }
    }

    /**
     * 管理员修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService1: AftersalesService
     * @return AftersalesService
     */
    @PutMapping("/admin/afterSaleServices/{id}")
    public Object updateAfterSaleByIdForAdmin(HttpServletRequest request, @PathVariable Integer id, @RequestBody AftersalesService afterSaleService1) throws UnknownHostException {
        Integer adminId = getAdminId(request);
        if(adminId == null) {
            return ResponseUtil.fail(660, "管理员未登录");
        }
        Log log = new Log();
        log.setAdminId(adminId);
        log.setActionId(id);
        log.setActions("修改售后服务");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(2); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());
        if (id == null) {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(693, "修改售后服务失败");
        } else {
            AftersalesService afterSaleService2 = afterSaleService.updateAfterSaleByIdForAdmin(id, afterSaleService1);
            if (afterSaleService2 == null) {
                log.setStatusCode(0);
                addLog.addLog(log);
                return ResponseUtil.fail(693, "修改售后服务失败");
            } else {
                log.setStatusCode(1);
                addLog.addLog(log);
                return ResponseUtil.ok(afterSaleService2);
            }
        }
    }

    /**
     * 用户修改某一售后服务的信息（必须先登录）
     *
     * @param id: Integer
     * @param afterSaleService1: AftersalesService
     * @return AftersalesService
     */
    @PutMapping("/afterSaleServices/{id}")
    public Object updateAfterSaleById(HttpServletRequest request, @PathVariable Integer id, @RequestBody AftersalesService afterSaleService1) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660, "用户未登录");
        }
        if (id == null) {
            return ResponseUtil.fail(693, "修改售后服务失败");
        } else {
            AftersalesService afterSaleService2 = afterSaleService.updateAfterSaleById(userId, id, afterSaleService1);
            if (afterSaleService2 == null) {
                return ResponseUtil.fail(693, "修改售后服务失败");
            } else {
                return ResponseUtil.ok(afterSaleService2);
            }
        }
    }

    /**
     * 查询用户的售后服务列表
     *
     * @param page: Integer
     * @param limit: Integer
     * @return List<AftersalesService>
     */
    @GetMapping("/afterSaleServices")
    public Object listAfterSalesByUserId(HttpServletRequest request,
                                         @RequestParam Integer page,
                                         @RequestParam Integer limit) { //
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660, "用户未登录");
        }
        if (page == null || limit == null
            || page <= 0 || limit <= 0) {
            return ResponseUtil.fail(691, "获取售后服务失败");
        } else {
            List<AftersalesService> afterSaleServices = afterSaleService.listAfterSalesByUserId(userId, page, limit);
            return ResponseUtil.ok(afterSaleServices);
        }
    }

    /**
     * 用户申请售后服务（必须先登录）
     *
     * @param afterSaleService1: AftersalesService
     * @return AftersalesService
     */
    @PostMapping("/afterSaleServices")
    public Object addAfterSale(HttpServletRequest request, @RequestBody AftersalesService afterSaleService1) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660, "用户未登录");
        }
        if (afterSaleService1 == null) {
            return ResponseUtil.fail(692, "申请售后服务失败"); //
        } else {
            AftersalesService afterSaleService2 = afterSaleService.addAfterSale(userId, afterSaleService1);
            if(afterSaleService2 != null) {
                return ResponseUtil.ok(afterSaleService2);
            } else {
                System.out.println("bad!"); //!!
                return ResponseUtil.fail(692, "申请售后服务失败");
            }
        }
    }

    /**
     * 用户逻辑删除某一个售后服务的信息（必须先登录）
     *
     * @param id: Integer
     * @return Response.ok()
     */
    @DeleteMapping("/afterSaleServices/{id}")
    public Object deleteAfterSaleById(HttpServletRequest request, @PathVariable Integer id) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660, "用户未登录");
        }
        if (id == null || afterSaleService.deleteAfterSaleById(userId, id) == 0) {
            return ResponseUtil.fail(694, "删除售后服务失败");
        } else {
            return ResponseUtil.ok();
        }
    }
}
