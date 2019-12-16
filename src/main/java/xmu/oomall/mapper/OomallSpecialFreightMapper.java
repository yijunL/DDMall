package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.SpecialFreight;

public interface OomallSpecialFreightMapper {
    SpecialFreight findAllById(@Param("id")Integer id);

}