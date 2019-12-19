package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.DefaultPieceFreightPo;
import xmu.oomall.mapper.OomallDefaultPieceFreightMapper;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DefaultPieceFreightDao {
    @Autowired
    private OomallDefaultPieceFreightMapper oomallDefaultPieceFreightMapper;

    public List<DefaultPieceFreightPo> getDefaultPieceFreight(Integer page, Integer limit)
    {
        return (List<DefaultPieceFreightPo>) PageCut.pageCut(oomallDefaultPieceFreightMapper.findAllByBeDeletedLessThan(1),page,limit);
    }

    public DefaultPieceFreightPo addDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo){
        if(defaultPieceFreightPo.getId()!=null)
            return null;
        if(defaultPieceFreightPo.getGmtCreate()==null)
            defaultPieceFreightPo.setGmtCreate(LocalDateTime.now());
        oomallDefaultPieceFreightMapper.insertSelective(defaultPieceFreightPo);
        return defaultPieceFreightPo;
    }

    public DefaultPieceFreightPo updateDefaultPieceFreight(Integer id, DefaultPieceFreightPo defaultPieceFreightPo){
        if(defaultPieceFreightPo.getId()!=null)
            return null;                        //id不允许有值，即不能修改id
        if(defaultPieceFreightPo.getGmtCreate()==null)
            defaultPieceFreightPo.setGmtModified(LocalDateTime.now());
        oomallDefaultPieceFreightMapper.updateById(defaultPieceFreightPo,id);
        return defaultPieceFreightPo;
    }

    public Boolean deleteDefaultPieceFreight(Integer id) {

        DefaultPieceFreightPo defaultPieceFreightPo=new DefaultPieceFreightPo();
        if(defaultPieceFreightPo == null)
            defaultPieceFreightPo.setGmtModified(LocalDateTime.now());
        defaultPieceFreightPo.setBeDeleted(true);
        if(oomallDefaultPieceFreightMapper.updateById(defaultPieceFreightPo,id)==0)  //没有更新任何元素
            return false;
        else
            return true;
    }
}