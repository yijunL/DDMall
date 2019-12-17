package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.SpecialFreight;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SpecialFreightDaoTest {
    @Autowired
    private SpecialFreightDao specialFreightDao;

    @Test
    public void getSpecialFreightsTest()
    {
        SpecialFreight specialFreight=specialFreightDao.getSpecialFreights(1);
        assertEquals(specialFreight.getId(),1);
    }

}