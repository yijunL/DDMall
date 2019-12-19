package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.AfterSaleService;
import xmu.oomall.mapper.OomallAfterSaleMapper;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: AfterSaleDao
 * @create 2019/12/14 14:20
 */
@Repository
public class AfterSaleDao {
    @Autowired
    private OomallAfterSaleMapper oomallAfterSaleMapper;

    /**
     * 管理员根据orderId查询售后服务列表
     *
     * @param orderId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    public List<AfterSaleService> selectAfterSalesByOrderId(Integer orderId, Integer page, Integer limit) {
        return null;
    }

    /**
     * 管理员根据id查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AfterSaleService
     */
    public AfterSaleService selectAfterSaleById(Integer id) {
        return null;
    }

    /**
     * 管理员根据id修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public AfterSaleService updateAfterSaleByIdForAdmin(Integer id, AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 用户根据id修改某一售后服务的信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public AfterSaleService updateAfterSaleById(Integer id, AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 查询用户的售后服务列表
     *
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    public List<AfterSaleService> selectAfterSalesByUserId(Integer page, Integer limit) {
        return null;
    }

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public AfterSaleService addAfterSale(AfterSaleService afterSaleService) {
        return null;
    }

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param id: Integer
     * @return Response.ok()
     */
    public int deleteAfterSaleById(Integer id) {
        return 0;
    }
}

