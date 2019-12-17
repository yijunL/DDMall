package xmu.oomall.service;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.tree.VoidDescriptor;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class FreightServiceTest {
    @Autowired
    private FreightService freightService;

    @Test
    public void deleteDefaultFreightTest()
    {
        freightService.deleteDefaultFreight(1);
    }
    @Test
    public void updateSpecialFreightTest(){
        SpecialFreight specialFreight=new SpecialFreight();
        specialFreight.setFirstNumPiece(3);
        specialFreight= freightService.updateSpecialFreights(1,specialFreight);
        assertEquals(specialFreight.getFirstNumPiece(),3);
        assertEquals(specialFreight.getId(),1);

        SpecialFreight specialFreight1=new SpecialFreight();
        specialFreight.setContinueNumPiece(2);
        specialFreight1=freightService.updateSpecialFreights(2,specialFreight1);
        assertEquals(specialFreight1,null);

    }
    @Test
    public void addSpecialFreightTest(){
        SpecialFreight specialFreight=new SpecialFreight();
        specialFreight.setFirstNumPiece(3);
        specialFreight.setContinueNumPiecePrice(new BigDecimal("40"));
        specialFreight= freightService.addSpecialFreight(specialFreight);
        assertEquals(specialFreight.getFirstNumPiece(),3);
        assertEquals(specialFreight.getContinueNumPiecePrice(),new BigDecimal("40"));
        //assertEquals(specialFreight.getId(),2);
    }

    @Test
    public void getSpecialFreightTest(){
        List<SpecialFreight> specialFreights=freightService.getAllSpecialFreight(2,2);
        assertEquals(specialFreights.get(0).getId(),4);
    }
}