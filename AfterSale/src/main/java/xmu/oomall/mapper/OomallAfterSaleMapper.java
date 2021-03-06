package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AftersalesService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Bexasusual
 * @Description: OomallAfterSaleMapper
 * @create 2019/12/13 14:20
 */
public interface OomallAfterSaleMapper {

    int insertSelective(AftersalesService afterSaleService);

    AftersalesService selectAllById(@Param("id")Integer id, @Param("userId")Integer userId);

    AftersalesService selectAllByIdForAdmin(@Param(("id"))Integer id);

    int deleteById(@Param("updatedGmtModified") LocalDateTime updatedGmtModified, @Param("id")Integer id, @Param("userId")Integer userId);

    int updateById(@Param("updatedGmtModified") LocalDateTime updatedGmtModified, @Param("id")Integer id, @Param("userId")Integer userId, @Param("updated")AftersalesService updated);

    int updateByIdForAdmin(@Param("updatedGmtModified") LocalDateTime updatedGmtModified, @Param("id")Integer id, @Param("updated")AftersalesService updated);

    List<AftersalesService> selectAllByUserId(@Param("userId")Integer userId); //用户查询自己售后列表与管理员按条件(userId)查询售后服务共用该方法

    List<AftersalesService> selectAllByCondition(@Param("userId")Integer userId);

}
