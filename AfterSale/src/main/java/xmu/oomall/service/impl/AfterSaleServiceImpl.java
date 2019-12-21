package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.OrderItemValidate;
import xmu.oomall.UserValidate;
import xmu.oomall.dao.AfterSaleDao;
import xmu.oomall.domain.AftersalesService;
import xmu.oomall.service.AfterSaleService;

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

    @Autowired
    private UserValidate userValidate;

    @Autowired
    private OrderItemValidate orderItemValidate;

    /**
     * 管理员查询售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AftersalesService>
     */
    @Override
    public List<AftersalesService> listAfterSalesByCondition(Integer userId, Integer page, Integer limit) {
        if (!userValidate.validate(userId)) {
            return null;
        }
        return afterSaleDao.selectAfterSalesByCondition(userId, page, limit);
    }

    /**
     * 用户查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AftersalesService
     */
    @Override
    public AftersalesService getAfterSaleById(Integer id) {
        AftersalesService afterSaleService = afterSaleDao.selectAfterSaleById(id);
        if(afterSaleService != null) {
            System.out.println(afterSaleService.getGoodsType());//
        }
        return afterSaleService;
    }

    /**
     * 管理员查询某一售后服务具体信息(下层查询是否与用户有区别？)
     *
     * @param id: Integer
     * @return AftersalesService
     */
    @Override
    public AftersalesService getAfterSaleByIdForAdmin(Integer id) {
        AftersalesService afterSaleService = afterSaleDao.selectAfterSaleById(id);
        if(afterSaleService != null) {
            System.out.println(afterSaleService.getGoodsType());//
        }
        return afterSaleService;
    }

    /**
     * 管理员修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    @Override
    public AftersalesService updateAfterSaleByIdForAdmin(Integer id, AftersalesService afterSaleService) {
        return afterSaleDao.updateAfterSaleByIdForAdmin(id, afterSaleService);
    }

    /**
     * 用户修改某一售后服务的信息（多余位暂时忽略，不报错）
     *
     * @param userId: Integer
     * @param id: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    @Override
    public AftersalesService updateAfterSaleById(Integer userId, Integer id, AftersalesService afterSaleService) {
        if (!userValidate.validate(userId)) {
            return null;
        }
        return afterSaleDao.updateAfterSaleById(id, afterSaleService);
    }

    /**
     * 查询用户的售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AftersalesService>
     */
    @Override
    public List<AftersalesService> listAfterSalesByUserId(Integer userId, Integer page, Integer limit) {
        if (!userValidate.validate(userId)) {
            return null;
        }
        return afterSaleDao.selectAfterSalesByUserId(userId, page, limit);
    }

    /**
     * 用户申请售后服务
     *
     * @param userId: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    @Override
    public AftersalesService addAfterSale(Integer userId, AftersalesService afterSaleService) {
        if (!userValidate.validate(userId)) {
            return null;
        }
        int goodsType = orderItemValidate.validate(afterSaleService.getOrderItemId()); //商品类型
        if (goodsType != 0 && goodsType != 1) { //如何表示该orderItem不存在？
            return null;
        }
        return afterSaleDao.addAfterSale(afterSaleService);
    }

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param userId: Integer
     * @param id: Integer
     * @return Response.ok()
     */
    @Override
    public int deleteAfterSaleById(Integer userId, Integer id) {
        if (!userValidate.validate(userId)) {
            return 0;
        }
        AftersalesService afterSaleService = afterSaleDao.selectAfterSaleById(id);
        if(afterSaleService != null && !afterSaleService.getBeDeleted()) {
            return afterSaleDao.deleteAfterSaleById(id);
        }
        System.out.println("删除失败"); //!!
        return 0;
    }

    /* 重复的方法——用户 */
//    public Object getAfterSaleById(Integer id);

}
