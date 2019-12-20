package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.AfterSaleService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
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
    private xmu.oomall.service.AfterSaleService afterSaleService;

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
     * 管理员查询售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    @GetMapping("/admin/afterSaleServices")
    public Object listAfterSalesByCondition(HttpServletRequest request, @RequestParam Integer userId, @RequestParam Integer page, @RequestParam Integer limit) {
        return null;
    }

    /**
     * 管理员查询某一售后服务具体信息（是否可与用户同用？）
     *
     * @param id: Integer
     * @return AfterSaleService
     */
    @GetMapping("/afterSaleServices/{id}")
    public Object getAfterSaleById(HttpServletRequest request, @PathVariable Integer id) {
        if(id == null) {
            return ResponseUtil.fail(691, "获取售后服务失败");
        } else {
            AfterSaleService afterSaleService1 = afterSaleService.getAfterSaleById(id);
            if(afterSaleService1 == null) {
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
     * @param afterSaleService1: AfterSaleService
     * @return AfterSaleService
     */
    @PutMapping("/admin/afterSaleServices/{id}")
    public Object updateAfterSaleByIdForAdmin(HttpServletRequest request, @PathVariable Integer id, @RequestParam AfterSaleService afterSaleService1) {
        if (id == null) {
            return ResponseUtil.fail(693, "修改售后服务失败");
        } else {
            AfterSaleService afterSaleService2 = afterSaleService.updateAfterSaleByIdForAdmin(id, afterSaleService1);
            if (afterSaleService2 == null) {
                return ResponseUtil.fail(693, "修改售后服务失败");
            } else {
                return ResponseUtil.ok(afterSaleService2);
            }
        }
    }

    /**
     * 用户修改某一售后服务的信息
     *
     * @param id: Integer
     * @param afterSaleService1: AfterSaleService
     * @return AfterSaleService
     */
    @PutMapping("/afterSaleServices/{id}")
    public Object updateAfterSaleById(HttpServletRequest request, @PathVariable Integer id, @RequestBody AfterSaleService afterSaleService1) {
        if (id == null) {
            return ResponseUtil.fail(693, "修改售后服务失败");
        } else {
            AfterSaleService afterSaleService2 = afterSaleService.updateAfterSaleById(id, afterSaleService1);
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
     * @return List<AfterSaleService>
     */
    @GetMapping("/afterSaleServices")
    public Object listAfterSalesByUserId(HttpServletRequest request,
                                         @RequestParam Integer page,
                                         @RequestParam Integer limit) { //
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(691, "获取售后服务失败");
        }
        if (page == null || limit == null
            || page < 0 || limit < 0) {
            return ResponseUtil.fail(691, "获取售后服务失败");
        } else {
            List<AfterSaleService> afterSaleServices = afterSaleService.listAfterSalesByUserId(userId, page, limit);
            return ResponseUtil.ok(afterSaleServices);
        }
    }

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService1: AfterSaleService
     * @return AfterSaleService
     */
    @PostMapping("/afterSaleServices")
    public Object addAfterSale(HttpServletRequest request, @RequestBody AfterSaleService afterSaleService1) {
        if(afterSaleService1 == null) {
            return ResponseUtil.fail(692, "申请售后服务失败"); //
        } else {
            AfterSaleService afterSaleService2 = afterSaleService.addAfterSale(afterSaleService1);
            if(afterSaleService2 != null) {
                return ResponseUtil.ok(afterSaleService2);
            } else {
                System.out.println("bad!"); //!!
                return ResponseUtil.fail(692, "申请售后服务失败");
            }
        }
    }

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param id: Integer
     * @return Response.ok()
     */
    @DeleteMapping("/afterSaleServices/{id}")
    public Object deleteAfterSaleById(HttpServletRequest request, @PathVariable Integer id) {
        if (id == null || afterSaleService.deleteAfterSaleById(id) == 0) {
            return ResponseUtil.fail(694, "删除售后服务失败");
        } else {
            return ResponseUtil.ok();
        }
    }

    /* 重复的方法——用户 */
//    @GetMapping("/afterSaleServices/{id}")
//    public Object getAfterSaleById(@PathVariable Integer id) {
//        return null;
//    }
}
