package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.DefaultFreightPo;

import java.math.BigDecimal;
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
        assertEquals(defaultFreightDao.getById(1).getBeDeleted(),true);
    }

    @Test
    public void findAllTest()
    {
        List<DefaultFreightPo> defaultFreightPoList=defaultFreightDao.getDefaultFreights(2,2);
        assertEquals(defaultFreightPoList.get(0).getId(),4);
    }

    @Test
    public void updateTest()
    {
        DefaultFreightPo defaultFreightPo=new DefaultFreightPo();
        defaultFreightPo.setRequireDays("1-3");
        BigDecimal testdec =new BigDecimal(88);
        defaultFreightPo.setOver10Price(new BigDecimal(8));
        defaultFreightPo.setOver50Price(testdec);
        defaultFreightDao.updateDefaultFreight(1,defaultFreightPo);
        //assertEquals(defaultFreightDao.getById(1).getOver50Price(),testdec);
    }

}