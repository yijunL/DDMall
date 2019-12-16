package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.mapper.SpecialFreightMapper;

@Repository
public class SpecialFreightDao {
    @Autowired
    SpecialFreightMapper specialFreightMapper;

    public SpecialFreight getSpecialFreights(Integer id) {
        return specialFreightMapper.findAllById(id);
    }
}