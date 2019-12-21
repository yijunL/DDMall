package xmu.oomall.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.service.ShareService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
class ShareServiceImplTest {

    @Autowired
    private ShareService shareService;
    @Test
    void addShareRule() throws Exception {
        ShareRulePo shareRulePo=new ShareRulePo();
        shareRulePo.setGoodsId(9998);
        shareRulePo.setBeDeleted(false);
        shareRulePo.setShareLevelStrategy(" {\"strategy\": [{\"lowerbound\":20, \"upperbound\":19, \"rate\":0.8},{\"lowerbound\":20, \"upperbound\":29, \"rate\":0.9}], \"type\": 0}");
        ShareRulePo shareRulePo1=(ShareRulePo)shareService.addShareRule(shareRulePo);

        assertEquals(shareRulePo1,null);
    }

    @Test
    void updateShareRule() {
    }
}