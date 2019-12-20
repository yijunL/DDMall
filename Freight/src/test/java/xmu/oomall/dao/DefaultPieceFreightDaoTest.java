package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.DefaultPieceFreightPo;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class DefaultPieceFreightDaoTest {
    @Autowired
    private DefaultPieceFreightDao defaultPieceFreightDao;

    @Test
    public void getDefaultPieceFreightsListTest()
    {
        List<DefaultPieceFreightPo> defaultPieceFreightPoList= defaultPieceFreightDao.getDefaultPieceFreight(1,1);
        DefaultPieceFreightPo defaultPieceFreightPo = defaultPieceFreightPoList.get(0);
        assertEquals(defaultPieceFreightPo.getId(),1);
    }

    @Test
    public void addDefaultPieceFreightTest(){
        DefaultPieceFreightPo defaultPieceFreightPo = new DefaultPieceFreightPo();
        defaultPieceFreightPo.setDestination("新疆乌鲁木齐");
        defaultPieceFreightPo.setRequireDays("2-3天");
        defaultPieceFreightPo.setUnitRate(new BigDecimal(2.00));
        defaultPieceFreightPo = defaultPieceFreightDao.addDefaultPieceFreight(defaultPieceFreightPo);
        assertEquals(defaultPieceFreightPo.getRequireDays(),"2-3天");
    }

    @Test
    public void updateDefaultPieceFreightTest(){
        DefaultPieceFreightPo defaultPieceFreightPo = new DefaultPieceFreightPo();
        defaultPieceFreightPo.setRequireDays("1-2天");
        defaultPieceFreightPo = defaultPieceFreightDao.updateDefaultPieceFreight(1,defaultPieceFreightPo);
        assertEquals(defaultPieceFreightPo.getRequireDays(),"1-2天");
    }

    @Test
    public void deleteDefaultPieceFreightTest()
    {
        defaultPieceFreightDao.deleteDefaultPieceFreight(1);
//        DefaultPieceFreightPo defaultPieceFreightPo = defaultPieceFreightDao.getDefaultPieceFreight(1,1).get(0);
//        assertEquals(defaultPieceFreightPo.getBeDeleted(),true);
    }
}
