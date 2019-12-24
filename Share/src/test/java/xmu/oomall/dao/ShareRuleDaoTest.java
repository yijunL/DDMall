package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.ShareRulePo;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class ShareRuleDaoTest {

    @Autowired
    private ShareRuleDao shareRuleDao;

    @Test
    void getShareRuleById() {
       ShareRulePo shareRulePo= shareRuleDao.getShareRuleById(1);
        assertEquals(shareRulePo.getId(),5);
    }

    @Test
    void addShareRule() {
        ShareRulePo shareRulePo=new ShareRulePo();
        shareRulePo.setGoodsId(1006239);
        shareRulePo.setBeDeleted(false);
        shareRulePo.setShareLevelStrategy("{\"straegy\": [{\"lowerbound\":\"0\", \"upperbound\":\"1\", \"rate\":\"0.5\"}," +
                "{\"lowerbound\":\"2\", \"upperbound\":\"10\", \"rate\":\"0.7\"},{\"lowerbound\":\"11\", \"upperbound\":\"30\", \"rate\":\"1\"}," +
                "{\"lowerbound\":\"31\", \"upperbound\":\"100\", \"rate\":\"1.5\"}],\"type\":\"0\"}");
        ShareRulePo shareRulePo1=shareRuleDao.addShareRule(shareRulePo);

        System.out.println(shareRulePo1);
    }

    @Test
    void deleteShareRuleById() {
        shareRuleDao.deleteShareRuleById(1);
        assertEquals(shareRuleDao.getShareRuleById(1).getBeDeleted(),true);
    }

    @Test
    void updateShareRule() {
        ShareRulePo shareRulePo=new ShareRulePo();
        shareRulePo.setGoodsId(666);
        ShareRulePo shareRulePo1= shareRuleDao.updateShareRule(shareRulePo,2);
        assertEquals(shareRulePo1.getGoodsId(),666);
    }




}