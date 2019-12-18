package xmu.oomall.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.SpecialFreight;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class FreightServiceTest {
    @Autowired
    private FreightService freightService;

    @Test
    public void deleteDefaultFreightTest() {
        freightService.deleteDefaultFreight(1);
    }

    @Test
    public void updateSpecialFreightTest() {
        SpecialFreight specialFreight = new SpecialFreight();
        specialFreight.setFirstNumPiece(3);
        specialFreight = freightService.updateSpecialFreights(1, specialFreight);
        assertEquals(specialFreight.getFirstNumPiece(), 3);
        assertEquals(specialFreight.getId(), 1);

        SpecialFreight specialFreight1 = new SpecialFreight();
        specialFreight.setContinueNumPiece(2);
        specialFreight1 = freightService.updateSpecialFreights(2, specialFreight1);
        assertEquals(specialFreight1, null);

    }

    @Test
    public void addSpecialFreightTest() {
        SpecialFreight specialFreight = new SpecialFreight();
        specialFreight.setFirstNumPiece(3);
        specialFreight.setContinueNumPiecePrice(new BigDecimal("40"));
        specialFreight = freightService.addSpecialFreight(specialFreight);
        assertEquals(specialFreight.getFirstNumPiece(), 3);
        assertEquals(specialFreight.getContinueNumPiecePrice(), new BigDecimal("40"));
        //assertEquals(specialFreight.getId(),2);
    }

    @Test
    public void getSpecialFreightTest() {
        List<SpecialFreight> specialFreights = freightService.getAllSpecialFreight(2, 2);
        assertEquals(specialFreights.get(0).getId(), 4);
    }
}