package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.AfterSaleService;

@SpringBootTest
//@Transactional //
public class AfterSaleControllerTest {
    @Autowired
    private AfterSaleController afterSaleController;

    @Test
    public void addAfterSale() {
        System.out.println(123);
    }
}
