package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.AftersalesService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
//@Transactional //
public class AfterSaleDaoTest {
    @Autowired
    private AfterSaleDao afterSaleDao;

    @Test
    public void insertAfterSale() {
        AftersalesService aftersalesService = new AftersalesService();
        aftersalesService.setApplyTime(LocalDateTime.now());
        aftersalesService.setId(87);
        aftersalesService.setBeDeleted(false);
        aftersalesService.setUserId(23);
        aftersalesService.setNumber(2);
        aftersalesService.setType(0);
        aftersalesService.setApplyReason("None2");
        aftersalesService.setGoodsType(1);
        aftersalesService.setBeApplied(true); //
        afterSaleDao.addAfterSale(aftersalesService);

        AftersalesService aftersalesService1 = new AftersalesService();
        aftersalesService1.setApplyTime(LocalDateTime.now());
        aftersalesService1.setId(92);
        aftersalesService1.setUserId(25);
        aftersalesService1.setBeDeleted(false);
        aftersalesService1.setNumber(6);
        aftersalesService1.setType(1);
        aftersalesService1.setApplyReason("Wow");
        aftersalesService1.setGoodsType(1);
        aftersalesService1.setBeApplied(false); //
        afterSaleDao.addAfterSale(aftersalesService1);
    }

    @Test
    public void selectByIdTest() {
        AftersalesService aftersalesService = afterSaleDao.selectAfterSaleById(6, 21);
        if(aftersalesService != null) {
            System.out.println(aftersalesService.getId() + aftersalesService.getApplyReason());
        } else{
            System.out.println("null");
        }

        AftersalesService aftersalesService1 = afterSaleDao.selectAfterSaleById(5, 23);
        if(aftersalesService1 != null) {
            System.out.println(aftersalesService1.getId() + aftersalesService1.getGoodsType());
        }
    }

    @Test
    public void selectByUserIdTest() {
        List<AftersalesService> aftersalesServiceList = afterSaleDao.selectAfterSalesByUserId(23, 1, 10);
        if(aftersalesServiceList == null) {
            System.out.println("null3");
        }
        System.out.println(aftersalesServiceList.size() + "\n");
        for (AftersalesService aftersalesService : aftersalesServiceList) {
            System.out.println(aftersalesService.getId() + " " + aftersalesService.getUserId()
                    + " " + aftersalesService.getBeDeleted() + " " + aftersalesService.getApplyReason());
        }
    }

    @Test
    public void selectByUserIdForAdminTest() {
        List<AftersalesService> aftersalesServiceList = afterSaleDao.selectAfterSalesByCondition(23, 1, 10);
        System.out.println(aftersalesServiceList.size() + "\n");
        for (AftersalesService aftersalesService : aftersalesServiceList) {
            System.out.println(aftersalesService.getId() + " " + aftersalesService.getUserId()
                    + " " + aftersalesService.getBeDeleted() + " " + aftersalesService.getApplyReason());
        }
    }

    @Test
    public void deleteByIdTest() {
        if (afterSaleDao.deleteAfterSaleById(11, 23) == 1) {
            System.out.println(11);
        }
        if (afterSaleDao.deleteAfterSaleById(12,23) == 1) {
            System.out.println(12);
        }
    }

    @Test
    public void updateById() {
        AftersalesService aftersalesService = new AftersalesService();
        aftersalesService.setId(9);
        aftersalesService.setApplyReason("break");
        aftersalesService.setType(0);
        aftersalesService.setNumber(1);
        afterSaleDao.updateAfterSaleById(7, 23, aftersalesService);
    }

    @Test
    public void updateByIdForAdmin() {
        AftersalesService aftersalesService = new AftersalesService();
        aftersalesService.setStatusCode(2); //
        aftersalesService.setApplyReason("aaaaaaa");
        AftersalesService aftersalesService1 = afterSaleDao.updateAfterSaleByIdForAdmin(8, aftersalesService);
        if(aftersalesService1 == null){
            System.out.println("updateAdminNull");
        }
    }
}
