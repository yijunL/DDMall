package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.mapper.OomallDefaultFreightMapper;
import xmu.oomall.util.Copyer;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultFreightDao {

    @Autowired
    private OomallDefaultFreightMapper oomallDefaultFreightMapper;

    public boolean deleteDefaultFreight(Integer id) {

        DefaultFreightPo defaultFreightPo=new DefaultFreightPo();
        defaultFreightPo.setGmtModified(LocalDateTime.now());
        defaultFreightPo.setBeDeleted(true);
        if(oomallDefaultFreightMapper.updateById(defaultFreightPo,id)==0)  //没有更新任何元素
            return false;
        else
            return true;
    }

    public DefaultFreightPo getById(Integer id)
    {
        return oomallDefaultFreightMapper.findAllById(id);
    }



    public List<DefaultFreightPo> getDefaultFreights(Integer page, Integer limit){
        return (List<DefaultFreightPo>) PageCut.pageCut(oomallDefaultFreightMapper.findAllByBeDeletedLessThan(1),page,limit);
    }

    public DefaultFreightPo updateDefaultFreight(Integer id,DefaultFreightPo defaultFreightPo){
        if(defaultFreightPo.getId()!=null)
            return null;                        //id不允许有值，即不能修改id
        defaultFreightPo.setGmtModified(LocalDateTime.now());
        oomallDefaultFreightMapper.updateById(defaultFreightPo,id);
        return oomallDefaultFreightMapper.findAllById(id);

    }

    public DefaultFreightPo addDefaultFreight(DefaultFreightPo defaultFreightPo){
        if(defaultFreightPo.getId()!=null)    //插入的po不能有id
            return null;
        defaultFreightPo.setGmtCreate(LocalDateTime.now());
        oomallDefaultFreightMapper.insertSelective(defaultFreightPo);
        return defaultFreightPo;
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