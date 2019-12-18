package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.AfterSaleDao;
import xmu.oomall.dao.FootprintDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.AfterSaleService;
import xmu.oomall.service.FootprintService;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: AfterSaleServiceImpl
 * @create 2019/12/17 14:10
 */

@Service
public class AfterSaleServiceImpl implements AfterSaleService {
    @Autowired
    private AfterSaleDao afterSaleDao;

    /**
     * 管理员查询售后服务列表
     *
     * @param orderId: Integer
     * @param page:    Integer
     * @param limit:   Integer
     * @return List<AfterSaleService>
     */
    @Override
    public List<xmu.oomall.domain.AfterSaleService> listAfterSalesByCondition(Integer orderId, Integer page, Integer limit) {
        return null;
    }

    /**
     * 管理员查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AfterSaleService
     */
    @Override
    public xmu.oomall.domain.AfterSaleService getAfterSaleById(Integer id) {
        return null;
    }

    /**
     * 管理员修改某一售后服务信息
     *
     * @param id:               Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    @Override
    public xmu.oomall.domain.AfterSaleService updateAfterSaleByIdForAdmin(Integer id, xmu.oomall.domain.AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 用户修改某一售后服务的信息
     *
     * @param id:               Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    @Override
    public xmu.oomall.domain.AfterSaleService updateAfterSaleById(Integer id, xmu.oomall.domain.AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 查询用户的售后服务列表
     *
     * @param page:  Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    @Override
    public List<xmu.oomall.domain.AfterSaleService> listAfterSalesByUserId(Integer page, Integer limit) {
        return null;
    }

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    @Override
    public xmu.oomall.domain.AfterSaleService addAfterSale(xmu.oomall.domain.AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param id: Integer
     * @return Response.ok()
     */
    @Override
    public int deleteAfterSaleById(Integer id) {
        return 0;
    }

    /* 重复的方法——用户 */
//    public Object getAfterSaleById(Integer id);

}
