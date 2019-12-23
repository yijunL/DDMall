package xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.UserValidate;
import xmu.oomall.domain.AftersalesService;
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
     * @return List<AftersalesService>
     */
    public List<AftersalesService> selectAfterSalesByCondition(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<AftersalesService> afterSaleServiceList = oomallAfterSaleMapper.selectAllByCondition(userId);
        return afterSaleServiceList;
    }

    /**
     * 用户根据id查询某一售后服务具体信息
     *
     * @param id: Integer
     * @param userId: Integer
     * @return AftersalesService
     */
    public AftersalesService selectAfterSaleById(Integer id, Integer userId) {
        return oomallAfterSaleMapper.selectAllById(id, userId);
    }

    /**
     * 管理员根据id查询某一售后服务具体信息
     *
     * @param id: Integer
     * @return AftersalesService
     */
    public AftersalesService selectAfterSaleByIdForAdmin(Integer id) {
        return oomallAfterSaleMapper.selectAllByIdForAdmin(id);
    }

    /**
     * 管理员根据id修改某一售后服务信息
     *
     * @param id: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    public AftersalesService updateAfterSaleByIdForAdmin(Integer id, AftersalesService afterSaleService) {
        if (oomallAfterSaleMapper.updateByIdForAdmin(LocalDateTime.now(), id, afterSaleService) > 0) { //还是>1（==3）？
            AftersalesService afterSaleService1 = oomallAfterSaleMapper.selectAllByIdForAdmin(id);
            return afterSaleService1;
        }
        return null;
    }

    /**
     * 用户根据id修改某一售后服务的信息
     *
     * @param id: Integer
     * @param userId: Integer
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    public AftersalesService updateAfterSaleById(Integer id, Integer userId, AftersalesService afterSaleService) {
        if (oomallAfterSaleMapper.updateById(LocalDateTime.now(), id, userId, afterSaleService) > 0) { //
            AftersalesService afterSaleService2 = oomallAfterSaleMapper.selectAllById(id, userId);
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
     * @return List<AftersalesService>
     */
    public List<AftersalesService> selectAfterSalesByUserId(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<AftersalesService> afterSaleServiceList = oomallAfterSaleMapper.selectAllByUserId(userId);
        return afterSaleServiceList;
    }

    /**
     * 用户申请售后服务
     *
     * @param afterSaleService: AftersalesService
     * @return AftersalesService
     */
    public AftersalesService addAfterSale(AftersalesService afterSaleService) {
        LocalDateTime time = LocalDateTime.now();
        afterSaleService.setGmtCreate(time); //是否现在赋值？
        afterSaleService.setGmtModified(time);
        afterSaleService.setApplyTime(time); //
        if (oomallAfterSaleMapper.insertSelective(afterSaleService) > 0) {
            System.out.println(afterSaleService.getId()); //
            return afterSaleService;
        }
        return null;
    }

    /**
     * 用户逻辑删除某一个售后服务的信息（需要判断userId是否相符）
     *
     * @param id: Integer
     * @param userId: Integer
     * @return Response.ok()
     */
    public int deleteAfterSaleById(Integer id, Integer userId) {
//        Integer i = oomallAfterSaleMapper.deleteById(LocalDateTime.now(), id, userId);
//        System.out.println(id + ": " + i);
        if (oomallAfterSaleMapper.deleteById(LocalDateTime.now(), id, userId) > 0) { //返回值是匹配的行数
            return 1;
        }
        return 0;
    }
}

