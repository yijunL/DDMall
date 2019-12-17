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
        SpecialFreight specialFreight= oomallSpecialFreightMapper.findAllById(id);
        if(specialFreight.getBeDeleted()==true)
            return null;
        else
            return specialFreight;
    }

    public List<SpecialFreight> getAllSpecialFreights(Integer page,Integer limit)
    {
        return (List<SpecialFreight>) PageCut.pageCut(oomallSpecialFreightMapper.findAllByBeDeletedLessThan(1),page,limit);
    }

    public boolean deleteSpecialFreight(Integer id)
    {
        return (oomallSpecialFreightMapper.deleteById(id)==1);
    }


}