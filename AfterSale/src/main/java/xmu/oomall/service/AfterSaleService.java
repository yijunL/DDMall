package xmu.oomall.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: AfterSaleService
 * @create 2019/12/17 14:00
 */

@Service
public interface AfterSaleService {

    /**
     * 管理员查询售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    public List<xmu.oomall.domain.AfterSaleService> listAfterSalesByCondition(Integer userId, Integer page, Integer limit);

    /**
     * 管理员查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AfterSaleService
     */
    public xmu.oomall.domain.AfterSaleService getAfterSaleById(Integer id);

    /**
     * 管理员修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public xmu.oomall.domain.AfterSaleService updateAfterSaleByIdForAdmin(Integer id, xmu.oomall.domain.AfterSaleService afterSaleService);

    /**
     * 用户修改某一售后服务的信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public xmu.oomall.domain.AfterSaleService updateAfterSaleById(Integer id, xmu.oomall.domain.AfterSaleService afterSaleService);

    /**
     * 查询用户的售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    public List<xmu.oomall.domain.AfterSaleService> listAfterSalesByUserId(Integer userId, Integer page, Integer limit);

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public xmu.oomall.domain.AfterSaleService addAfterSale(xmu.oomall.domain.AfterSaleService afterSaleService);

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param id: Integer
     * @return Response.ok()
     */
    public int deleteAfterSaleById(Integer id);

    /* 重复的方法——用户 */
//    public Object getAfterSaleById(Integer id);
}
