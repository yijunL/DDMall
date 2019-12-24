package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest

public class LogisticsControllerTest {
    @Autowired
    LogisticsController logisticsController;

    @Test
    public void LogisticsTest() {
        System.out.println(logisticsController.getLogistics());
    }
}