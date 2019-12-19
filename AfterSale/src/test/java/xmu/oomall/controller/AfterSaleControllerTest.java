package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.service.AfterSaleService;

@SpringBootTest
//@Transactional //
public class AfterSaleControllerTest {
    @Autowired
    private AfterSaleController afterSaleController;

    @Test
    public void insertAfterSale() {
        xmu.oomall.domain.AfterSaleService afterSaleService = new xmu.oomall.domain.AfterSaleService();
        afterSaleService.setGoodsType(97);
        afterSaleController.addAfterSale(afterSaleService);
    }

    @Test
    public void selectAfterSale() {
        afterSaleController.getAfterSaleById(1);
    }

    @Test
    public void deleteAfterSale() {
        afterSaleController.deleteAfterSaleById(1);
    }
}
