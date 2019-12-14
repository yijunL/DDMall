package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.oomall.domain.DefaultFreightPo;

@Mapper
@Component
public interface DefaultFreightMapper {

    void deleteDefaultFreight(Integer id);
    //void updateDefaultFreight(Integer id,DefaultFreightPo defaultFreightPo);
}