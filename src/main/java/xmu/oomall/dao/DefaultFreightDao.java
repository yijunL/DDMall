package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.mapper.OomallDefaultFreightMapper;
import xmu.oomall.util.Copyer;
import xmu.oomall.util.PageCut;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultFreightDao {

    @Autowired
    private OomallDefaultFreightMapper oomallDefaultFreightMapper;

    public boolean deleteDefaultFreight(Integer id) {
        return oomallDefaultFreightMapper.deleteDefaultFreight(id);
    }

    public List<DefaultFreightPo> getDefaultFreights(Integer page, Integer limit){
        return (List<DefaultFreightPo>) PageCut.pageCut(oomallDefaultFreightMapper.findAllByBeDeletedLessThan(1),page,limit);
    }










































    public DefaultFreight changeDefaultFreight(DefaultFreightPo defaultFreightPo){
        DefaultFreight defaultFreight=new DefaultFreight();
        return Copyer.Copy(defaultFreightPo,defaultFreight)?defaultFreight:null;
    }

    public List<DefaultFreight> changeDefaultFreightList(List<DefaultFreightPo> defaultFreightPoList){
        if(defaultFreightPoList==null){
            return null;
        }
        else{
            List<DefaultFreight> defaultFreightList=new ArrayList<>();
            for(DefaultFreightPo defaultFreightPo:defaultFreightPoList){
                defaultFreightList.add(changeDefaultFreight(defaultFreightPo));
            }
            return defaultFreightList;
        }
    }

}