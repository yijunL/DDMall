package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreightPo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DefaultFreightDaoTest {
    @Autowired
    private DefaultFreightDao defaultFreightDao;

//    @Test
//    public void deleteTest()
//    {
//        defaultFreightDao.deleteDefaultFreight(1);
//    }
    @Test
    public void findAllTest()
    {
        List<DefaultFreightPo> defaultFreightPoList=defaultFreightDao.getDefaultFreights(1,2);
        assertEquals(defaultFreightPoList.get(0).getId(),1);
    }
}