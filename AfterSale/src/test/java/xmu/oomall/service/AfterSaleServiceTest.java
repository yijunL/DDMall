package xmu.oomall.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AfterSaleServiceTest {
    @Autowired
    private AfterSaleService afterSaleService;

    @Test
    public void selectByIdForAdminTest() {
        if (afterSaleService.listAfterSalesByCondition(23,1,10) != null) {
            System.out.println("selectByUserId ok");
        };
        System.out.println("selectByUserId error");
    }
}
