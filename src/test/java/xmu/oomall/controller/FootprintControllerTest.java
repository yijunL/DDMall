package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.FootprintItemPo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional //
public class FootprintControllerTest {
    @Autowired
    private FootprintController footprintController;

    @Test
    public void addFootprintTest() {
        FootprintItemPo footprintItemPo = new FootprintItemPo();
        footprintItemPo.setGoodsId(12);
        footprintItemPo.setUserId(177);
        footprintController.addFootprint(footprintItemPo);
    }

    @Test
    public void selectByConditionTest() {
        footprintController.listFootprintsByCondition(177, null, 1,10);
    }
}
