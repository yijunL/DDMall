package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.mapper.OomallSpecialFreightMapper;

@Repository
public class SpecialFreightDao {
    @Autowired
    OomallSpecialFreightMapper oomallSpecialFreightMapper;

    public SpecialFreight getSpecialFreights(Integer id) {
        return oomallSpecialFreightMapper.findAllById(id);
    }

}