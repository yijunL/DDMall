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


    /**
     * 获取分享规则，通过goodsID

     */
    public ShareRulePo getShareRuleById(Integer id) {
        ShareRulePo sharerulepo = shareRuleMapper.findByGoodsId(id) ;
        return sharerulepo;
    }

    /**
     * 增添分享规则

     */
    public ShareRulePo addShareRule(ShareRulePo sharerulePo) {

        ShareRulePo shareRule=shareRuleMapper.findByGoodsId(sharerulePo .getGoodsId());
        if(shareRule==null)
        {
            sharerulePo.setGmtCreate(LocalDateTime.now());
            sharerulePo.setGmtModified((LocalDateTime.now()));
            shareRuleMapper.insertSelective(sharerulePo);
            return sharerulePo;
        }
        else if (shareRule.getBeDeleted()==true)
        {
            sharerulePo.setGmtCreate(LocalDateTime.now());
            sharerulePo.setGmtModified(LocalDateTime.now());
            shareRule.setBeDeleted(false);
            shareRuleMapper.updateById(sharerulePo, shareRule.getId());
            return sharerulePo;
        }
        else
        {
            return null;
        }
    }

    /**
     * 删除分享规则

     */

    public boolean deleteShareRuleById(Integer id) {

        ShareRulePo shareRulePo=shareRuleMapper.findById(id);
        if(shareRulePo==null)
            return false;
       else
        {
            if(shareRulePo.getBeDeleted()==false)
                return shareRuleMapper.deleteById(id);
            else
                return false;
        }

    }
    /**
     * 修改分享规则

     */

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
