package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.OomallApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OomallApplication.class)
public class DefaultFreightDaoTest {
    @Autowired
    private DefaultFreightDao defaultFreightDao;

    @Test
    public void test()
    {
        int a=defaultFreightDao.getDefaultFreights();
        assertEquals(a, 1);
    }


}