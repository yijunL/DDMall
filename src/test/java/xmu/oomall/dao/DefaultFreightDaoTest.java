package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreightPo;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DefaultFreightDaoTest {
    @Autowired
    private DefaultFreightDao defaultFreightDao;

    @Test
    public void test()
    {
        DefaultFreightPo defaultFreightPo =defaultFreightDao.getDefaultFreights(1);
        assertEquals(defaultFreightPo.getId(), 1);
    }


}