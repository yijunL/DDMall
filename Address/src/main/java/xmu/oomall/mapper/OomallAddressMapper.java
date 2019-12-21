package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AddressPo;

import java.util.List;

public interface OomallAddressMapper {
    int updateById(@Param("updated") AddressPo updated, @Param("id") Integer id);
    int insertSelective(AddressPo addressPo);
    List<AddressPo> findAllByUserIdAndBeDeletedLessThan(@Param("userId")Integer userId,@Param("maxBeDeleted")int maxBeDeleted);


    AddressPo findAllById(@Param("id") Integer id);

}