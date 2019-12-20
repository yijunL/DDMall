package xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.AfterSaleService;
import xmu.oomall.mapper.OomallAfterSaleMapper;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
     * 管理员根据userId查询售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    public List<AfterSaleService> selectAfterSalesByCondition(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(limit,page);
        List<AfterSaleService> afterSaleServiceList = oomallAfterSaleMapper.selectAllByUserId(userId);
        return afterSaleServiceList;
    }

    /**
     * 管理员根据id查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AfterSaleService
     */
    public AfterSaleService selectAfterSaleById(Integer id) {
        return oomallAfterSaleMapper.selectAllById(id);
    }

    /**
     * 管理员根据id修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public AfterSaleService updateAfterSaleByIdForAdmin(Integer id, AfterSaleService afterSaleService) {
        if (oomallAfterSaleMapper.updateByIdForAdmin(LocalDateTime.now(), id, afterSaleService) > 0) { //
            AfterSaleService afterSaleService1 = oomallAfterSaleMapper.selectAllById(id);
            return afterSaleService1;
        }
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
        AfterSaleService afterSaleService1 = oomallAfterSaleMapper.selectAllById(id);
        if (afterSaleService1.getStatusCode() != 0) { //不可修改
            return null;
        }
        if (oomallAfterSaleMapper.updateById(LocalDateTime.now(), id, afterSaleService) > 0) { //
            AfterSaleService afterSaleService2 = oomallAfterSaleMapper.selectAllById(id);
            return afterSaleService2;
        }
        return null;
    }

    /**
     * 查询用户的售后服务列表
     *
     * @param userId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<AfterSaleService>
     */
    public List<AfterSaleService> selectAfterSalesByUserId(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(limit,page);
        List<AfterSaleService> afterSaleServiceList = oomallAfterSaleMapper.selectAllByUserId(userId);
        return afterSaleServiceList;
    }

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService: AfterSaleService
     * @return AfterSaleService
     */
    public AfterSaleService addAfterSale(AfterSaleService afterSaleService) {
//        if(afterSaleService.getId() != null) {
//            return null;
//        } else {
//            if(oomallAfterSaleMapper.insertSelective(afterSaleService) > 0) {
//                System.out.println(afterSaleService.getId()); //
//                return afterSaleService;
//            }
//            return null;
//        }
        if(oomallAfterSaleMapper.insertSelective(afterSaleService) > 0) {
            System.out.println(afterSaleService.getId()); //
            return afterSaleService;
        }
        return null;
    }

    /**
     * 用户逻辑删除某一个售后服务的信息
     *
     * @param id: Integer
     * @return Response.ok()
     */
    public int deleteAfterSaleById(Integer id) {
        if(oomallAfterSaleMapper.deleteById(LocalDateTime.now(), id) == 2) { //应更新2行
            return 1;
        } else {
            return 0;
        }
    }
}

