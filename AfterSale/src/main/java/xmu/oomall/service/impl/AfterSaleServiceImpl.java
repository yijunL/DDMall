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
     * @param userId: Integer
     * @return AftersalesService
     */
    @Override
    public AftersalesService getAfterSaleById(Integer id, Integer userId) {
        if (!userValidate.validate(userId)) {
            return null;
        }
        return afterSaleDao.selectAfterSaleById(id, userId);
    }

    /**
     * 管理员查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AftersalesService
     */
    @Override
    public AftersalesService getAfterSaleByIdForAdmin(Integer id) {
        return afterSaleDao.selectAfterSaleByIdForAdmin(id);
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
        Integer statusCode = afterSaleService.getStatusCode(),
                one = new Integer(1), two = new Integer(2);
        if (statusCode == null) {
            return null;
        } else if (!(statusCode.equals(one) || statusCode.equals(two))) {
            return null;
        }
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
        Integer statusCode = afterSaleService.getStatusCode();
        if (statusCode != null && statusCode != 0) {
            return null;
        }
        Integer type = afterSaleService.getType();
        if (type != null) {
            if (type != 0 && type != 1) {
                return null;
            } else {
                afterSaleService.setType(type);
            }
        }
        Integer number = afterSaleService.getNumber();
        if (number != null) {
            if (number <= 0) {
                return null;
            } else {
                afterSaleService.setNumber(number);
            }
        }
        if (!userValidate.validate(userId)) {
            return null;
        }
        return afterSaleDao.updateAfterSaleById(id, userId, afterSaleService);
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
        /* 先判断不需要调用其他服务的部分，可能节约时间 */
        /* 检查is_applied, orderItemId, number等 */
        Boolean beDeleted = afterSaleService.getBeDeleted();
        if (beDeleted != null && beDeleted == true) {
            return null;
        }
        //是否插入beDeleted？
        Boolean beApplied = afterSaleService.getBeApplied();
        if (beApplied != null && beApplied == false) {
            return null;
        }
        //是否插入beApplied？
        Integer type = afterSaleService.getType();
        if (type == null) {
            return null;
        } else if (!(type.equals(0) || type.equals(1))) {
            return null;
        }
        afterSaleService.setType(type);
        Integer number = afterSaleService.getNumber();
        if (number == null || number <= 0) {
            return null;
        }
        afterSaleService.setNumber(number);
        /* !! */
        if (!userValidate.validate(userId)) {
            return null;
        }
        afterSaleService.setUserId(userId);
        if (afterSaleService.getOrderItemId() == null) {
            return null;
        }
        Integer goodsType = orderItemValidate.validate(afterSaleService.getOrderItemId());
        afterSaleService.setGoodsType(goodsType);
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
        return afterSaleDao.deleteAfterSaleById(id, userId);
    }

}
