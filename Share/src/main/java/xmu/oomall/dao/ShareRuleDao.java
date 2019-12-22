package xmu.oomall.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.ShareRule;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.mapper.OomallShareRuleMapper;
import xmu.oomall.util.Copyer;

import java.time.LocalDateTime;

@Repository
public class ShareRuleDao {

    @Autowired
    private OomallShareRuleMapper shareRuleMapper;

    public ShareRulePo getShareRuleById(Integer id) {
        ShareRulePo sharerulepo = shareRuleMapper.findByGoodsId(id) ;
        return sharerulepo;
    }

    public ShareRulePo addShareRule(ShareRulePo sharerulePo) {

        if(shareRuleMapper.findByGoodsId(sharerulePo .getGoodsId())!=null)
            return null;
        else{
                sharerulePo.setGmtCreate(LocalDateTime.now());
                sharerulePo.setGmtModified((LocalDateTime.now()));
        int ok=shareRuleMapper.insertSelective(sharerulePo);
        if(ok==0)
            return null;
        else
            return sharerulePo;
        }
    }


    public boolean deleteShareRuleById(Integer id) {

        if(shareRuleMapper.findById(id)==null)
            return false;
       else
        {if(shareRuleMapper.deleteById(id))
           return true;
        else
            return false;}

    }

    public ShareRulePo updateShareRule(ShareRulePo sharerulePo,Integer id) {

        if(shareRuleMapper.findById(id)==null)
            return null;
        else{
            sharerulePo.setGmtModified(LocalDateTime.now());
            shareRuleMapper.updateById(sharerulePo,id);
            return sharerulePo;
        }

    }



    public ShareRule changeShareRule(ShareRulePo shareRulePo)
    {
        ShareRule shareRule=new ShareRule();
        return Copyer.Copy(shareRulePo,shareRule)?shareRule:null;
    }

}
