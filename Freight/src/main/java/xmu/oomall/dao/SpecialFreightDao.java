package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.mapper.OomallSpecialFreightMapper;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class SpecialFreightDao {
    @Autowired
    OomallSpecialFreightMapper oomallSpecialFreightMapper;

    public SpecialFreight getSpecialFreights(Integer id) {
        SpecialFreight specialFreight = oomallSpecialFreightMapper.findAllById(id);
        if (specialFreight.getBeDeleted() == true)
            return null;
        else
            return specialFreight;
    }

    public List<SpecialFreight> getAllSpecialFreights(Integer page, Integer limit) {
        return (List<SpecialFreight>) PageCut.pageCut(oomallSpecialFreightMapper.findAllByBeDeletedLessThan(1), page, limit);
    }

    public boolean deleteSpecialFreight(Integer id) {
        SpecialFreight specialFreight = new SpecialFreight();
        specialFreight.setGmtModified(LocalDateTime.now());
        specialFreight.setBeDeleted(true);
        if (oomallSpecialFreightMapper.updateById(specialFreight, id) == 0) //没有更新任何元素
            return false;
        else
            return true;

    }

    public SpecialFreight updateSpecialFreight(SpecialFreight specialFreight, Integer id) {
        if (specialFreight.getId() != null)
            return null;
        else {
            specialFreight.setGmtCreate(LocalDateTime.now());
            oomallSpecialFreightMapper.updateById(specialFreight, id);
            return oomallSpecialFreightMapper.findAllById(id);
        }
    }

    public SpecialFreight addSpecialFreight(SpecialFreight specialFreight) {
        if (specialFreight.getId() != null) {
            return null;
        } else {
            specialFreight.setGmtCreate(LocalDateTime.now());
            oomallSpecialFreightMapper.insertSelective(specialFreight);
            return specialFreight;
        }
    }


}