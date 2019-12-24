package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AddressPo;

import java.util.List;

/**
 * @Author 3204
 * @Description: OomallAddressMapper
 * @create 2019/12/16 20:49
 */
public interface OomallAddressMapper {
    /**
     * 修改地址
     * @param updated
     * @param id
     * @return
     */
    int updateById(@Param("updated") AddressPo updated, @Param("id") Integer id);

    /**
     * 插入地址
     * @param addressPo
     * @return
     */
    int insertSelective(AddressPo addressPo);

    /**
     * 查询未删除的地址列表
     * @param userId
     * @param maxBeDeleted
     * @return
     */
    List<AddressPo> findAllByUserIdAndBeDeletedLessThan(@Param("userId")Integer userId,@Param("maxBeDeleted")int maxBeDeleted);

    /**
     * 查询某个地址
     * @param id
     * @return
     */
    AddressPo findAllById(@Param("id") Integer id);

    /**
     * 修改默认地址
     * @param updatedBeDefault
     * @param userId
     * @return
     */
    int updateBeDefaultByUserId(@Param("updatedBeDefault")Boolean updatedBeDefault,@Param("userId")Integer userId);



}