package xmu.oomall.mapper;
import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.DefaultFreightPo;

public interface OomallDefaultFreightMapper {
    boolean deleteDefaultFreight(Integer id);


    DefaultFreightPo findAllById(@Param("id")Integer id);


    List<DefaultFreightPo> findAllByBeDeletedLessThan(@Param("maxBeDeleted")Integer maxBeDeleted);





}