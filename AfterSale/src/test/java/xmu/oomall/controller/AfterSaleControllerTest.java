package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.AftersalesService;
import xmu.oomall.service.AfterSaleService;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
@Transactional //
public class AfterSaleControllerTest {
    @Autowired
    private AfterSaleController afterSaleController;

    @Test
    public void insertAfterSale() {
//        AftersalesService afterSaleService = new AftersalesService();
//        afterSaleService.setGoodsType(97);
//        HttpServletRequest request = null;
//        afterSaleController.addAfterSale(request, afterSaleService);
    }

//    @Test
//    public void selectAfterSale() {
//        HttpServletRequest request = null;
//        afterSaleController.getAfterSaleById(request,1);
//    }
//
//    @Test
//    public void deleteAfterSale() {
//        HttpServletRequest request = null;
//        afterSaleController.deleteAfterSaleById(request,1);
//    }
}
