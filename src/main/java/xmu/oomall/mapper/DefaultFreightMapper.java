package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.DefaultFreightPo;

public interface DefaultFreightMapper {
    boolean deleteDefaultFreight(Integer id);


    DefaultFreightPo findAllById(@Param("id")Integer id);


}