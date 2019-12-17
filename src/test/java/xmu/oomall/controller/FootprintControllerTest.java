package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.service.FreightService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FootprintControllerTest {
    @Autowired
    private FootprintController footprintController;

    @Test
    public void footprintControllerTest() {
        footprintController.deleteFootprintById(1);
    }

//    @Test
//    void setFootprintController() {
//        FootprintItemPo footprintItemPo = new FootprintItemPo();
//        footprintItemPo.setGoodsId(12);
//        footprintItemPo.setId(99);
//        footprintController.addFootprint(177, footprintItemPo);
//    }
}
