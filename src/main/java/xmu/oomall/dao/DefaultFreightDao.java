package xmu.oomall.dao;

import org.springframework.stereotype.Repository;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.mapper.DefaultFreightMapper;

import java.util.List;

@Repository
public class DefaultFreightDao {



    public List<DefaultFreightPo> getDefaultFreights(){
        return DefaultFreightMapper.getDefaultFreights();
    }

}