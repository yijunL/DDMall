package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AfterSaleService;

import java.time.LocalDateTime;
import java.util.List;

public interface OomallAfterSaleMapper {

    int insertSelective(AfterSaleService afterSaleService);

    AfterSaleService selectAllById(@Param("id")Integer id);

    int deleteById(@Param("updatedGmtModified") LocalDateTime updatedGmtModified, @Param("id")Integer id);

    int updateById(@Param("updatedGmtModified") LocalDateTime updatedGmtModified, @Param("id")Integer id, @Param("updated")AfterSaleService updated);

    int updateByIdForAdmin(@Param("updatedGmtModified") LocalDateTime updatedGmtModified, @Param("id")Integer id, @Param("updated")AfterSaleService updated);

    List<AfterSaleService> selectAllByUserId(@Param("userId")Integer userId); //用户查询自己售后列表与管理员按条件(userId)查询售后服务共用该方法

}
