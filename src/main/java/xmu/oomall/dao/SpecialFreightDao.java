package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.mapper.OomallSpecialFreightMapper;
import xmu.oomall.util.PageCut;

import java.util.List;

@Repository
public class SpecialFreightDao {
    @Autowired
    OomallSpecialFreightMapper oomallSpecialFreightMapper;

    public SpecialFreight getSpecialFreights(Integer id) {
        return oomallSpecialFreightMapper.findAllById(id);
    }

    public List<SpecialFreight> getAllSpecialFreights(Integer page,Integer limit)
    {
        return (List<SpecialFreight>) PageCut.pageCut(oomallSpecialFreightMapper.findAllByBeDeletedLessThan(1),page,limit);
    }


}