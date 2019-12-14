package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.mapper.DefaultFreightMapper;

import java.util.List;

@Repository
public class DefaultFreightDao {

    @Autowired
    private DefaultFreightMapper defaultFreightMapper;

    public void deleteDefaultFreight(Integer id) {
        defaultFreightMapper.deleteDefaultFreight(id);
    }
}