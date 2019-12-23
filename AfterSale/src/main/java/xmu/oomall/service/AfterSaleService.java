package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.AftersalesService;

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
     * @return List<AftersalesService>
     */
    public List<AftersalesService> listAfterSalesByCondition(Integer userId, Integer page, Integer limit);

    /**
     * 用户查询某一售后服务具体信息
     *
     * @param id: Integer
     * @param userId: Integer
     * @return AftersalesService
     */
    public AftersalesService getAfterSaleById(Integer id, Integer userId); //!!

    /**
     * 管理员查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AftersalesService
     */
    public AftersalesService getAfterSaleByIdForAdmin(Integer id);

    /**
     * 管理员修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    public AftersalesService updateAfterSaleByIdForAdmin(Integer id, AftersalesService afterSaleService);

    /**
     * 用户修改某一售后服务的信息
     *
     * @param userId: Integer
     * @param id: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    public AftersalesService updateAfterSaleById(Integer userId, Integer id, AftersalesService afterSaleService);

    /**
     * 查询用户的售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AftersalesService>
     */
    public List<AftersalesService> listAfterSalesByUserId(Integer userId, Integer page, Integer limit);

    /**
     * 用户申请售后服务
     *
     * @param userId: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    public AftersalesService addAfterSale(Integer userId, AftersalesService afterSaleService);

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param userId: Integer
     * @param id: Integer
     * @return Response.ok()
     */
    public int deleteAfterSaleById(Integer userId, Integer id);

}
