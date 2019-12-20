package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.FootprintItemPo;

import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = null;
        footprintController.addFootprint(request, footprintItemPo);
    }

    @Test
    public void selectByConditionTest() {
        HttpServletRequest request = null;
        footprintController.listFootprintsByCondition(request,177, null, 1,10);
    }
}
