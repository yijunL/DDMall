package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AddressPo;

import java.util.List;

public interface OomallAddressMapper {
    List<AddressPo> findAllById(@Param("id") Integer id);

    int updateById(@Param("updated") AddressPo updated, @Param("id") Integer id);

    int insertSelective(AddressPo addressPo);


}