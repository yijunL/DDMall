package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.util.ResponseUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class FreightControllerTest {
    @Autowired
    private FreightController freightController;
    @Autowired
    private DefaultFreightDao defaultFreightDao;

//    @Test
//    public void deleteDefaultFreightTest()
//    {
//        freightController.deleteDefaultFreight(1);
//        assertEquals(defaultFreightDao.getById(1).getBeDeleted(),true);
//    }
//    @Test
//    public void getAllDefaultFreightTest()
//    {
//        Object obj  =freightController.getDefaultFreights(2,2);
//        assertEquals(defaultFreightPoList.get(0).getId(),3);
//    }
//    @Test
//    public void getSpecialFreightByIdTest()
//    {
//        SpecialFreight specialFreight=freightController.getSpecialFreights(1);
//        assertEquals(specialFreight.getId(),1);
//    }

//    @Test
//    public void addDefaultFreightTest()
//    {
//        DefaultFreightPo defaultFreightPo=new DefaultFreightPo();
//        defaultFreightPo.setRequireDays("1-3");
//
//        defaultFreightPo.setOver10Price(new BigDecimal(10));
//        defaultFreightPo.setOver50Price(new BigDecimal(100));
//        defaultFreightPo=freightController.addDefaultFreight(defaultFreightPo);
//        assertEquals(defaultFreightPo.getId(),36);
//    }

}