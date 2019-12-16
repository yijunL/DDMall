package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FreightControllerTest {
    @Autowired
    private FreightController freightController;

/*    @Test
    public void deleteDefaultFreightTest()
    {
        freightController.deleteDefaultFreight(1);
    }*/
    @Test
    public void getAllDefaultFreightTest()
    {
        List<DefaultFreightPo> defaultFreightPoList=freightController.getDefaultFreights(1,2);
        assertEquals(defaultFreightPoList.get(0).getId(),1);
    }
    @Test
    public void getSpecialFreightByIdTest()
    {
        SpecialFreight specialFreight=freightController.getSpecialFreights(1);
        assertEquals(specialFreight.getId(),1);
    }


}