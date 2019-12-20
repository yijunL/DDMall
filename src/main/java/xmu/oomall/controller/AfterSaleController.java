package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;

/**
 * @Author Bexasusual
 * @Description: AfterSaleController
 * @create 2019/12/16 20:49
 */
@RestController
@RequestMapping("afterSaleServices") //!!
public class AfterSaleController {
    private static final Logger logger = LoggerFactory.getLogger(AfterSaleController.class);

    @Autowired
    private xmu.oomall.service.AfterSaleService afterSaleService;

    /**
     * 管理员查询售后服务列表
     *
     * @param orderId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    @GetMapping("/admin/afterSaleServices")
    public Object listAfterSalesByCondition(@RequestParam Integer orderId, @RequestParam Integer page, @RequestParam Integer limit) {
        return null;
    }

    /**
     * 管理员查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AfterSaleService
     */
    @GetMapping("/afterSaleServices/{id}")
    public Object getAfterSaleById(@PathVariable Integer id) {
        return null;
    }

    /**
     * 管理员修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    @PutMapping("/admin/afterSaleServices/{id}")
    public Object updateAfterSaleByIdForAdmin(@PathVariable Integer id, @RequestParam AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 用户修改某一售后服务的信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    @PutMapping("/afterSaleServices/{id}")
    public Object updateAfterSaleById(@PathVariable Integer id, @RequestBody AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 查询用户的售后服务列表
     *
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    @GetMapping("/afterSaleServices")
    public Object listAfterSalesByUserId(@RequestParam Integer page, @RequestParam Integer limit) { //
        return null;
    }

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    @PostMapping("/afterSaleServices")
    public Object addAfterSale(@RequestBody AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param id: Integer
     * @return Response.ok()
     */
    @DeleteMapping("/afterSaleServices/{id}")
    public Object deleteAfterSaleById(@PathVariable Integer id) {
        return null;
    }

    /* 重复的方法——用户 */
//    @GetMapping("/afterSaleServices/{id}")
//    public Object getAfterSaleById(@PathVariable Integer id) {
//        return null;
//    }
}
