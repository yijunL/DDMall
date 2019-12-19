package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.AfterSaleService;

import java.util.List;

public interface OomallAfterSaleMapper {

    int insertSelective(AfterSaleService afterSaleService);
}
