package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.SpecialFreight;

public interface SpecialFreightMapper {
    SpecialFreight findAllById(@Param("id")Integer id);

}