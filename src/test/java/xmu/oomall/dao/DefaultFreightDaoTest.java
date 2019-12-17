package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.DefaultFreightPo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class DefaultFreightDaoTest {
    @Autowired
    private DefaultFreightDao defaultFreightDao;

    @Test
    public void deleteTest()
    {
        defaultFreightDao.deleteDefaultFreight(1);
    }

    @Test
    public void findAllTest()
    {
        List<DefaultFreightPo> defaultFreightPoList=defaultFreightDao.getDefaultFreights(2,2);
        assertEquals(defaultFreightPoList.get(0).getId(),4);
    }
}