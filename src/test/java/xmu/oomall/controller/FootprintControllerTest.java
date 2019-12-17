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
    public void footprintControllerTest() {
        footprintController.deleteFootprintById(99);
    }

    @Test
    public void addFootprintTest() {
        FootprintItemPo footprintItemPo = new FootprintItemPo();
        footprintItemPo.setGoodsId(12);
        footprintItemPo.setId(99);
        footprintController.addFootprint(177, footprintItemPo);
    }

    @Test
    public void selectByConditionTest() { //测试能通过，但并不正确（无法查询到正确的列表)
        footprintController.listFootprintsByCondition("1", "12", 1,10);
    }
}
