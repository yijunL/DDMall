package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.AftersalesService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
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
        aftersalesService.setBeApplied(true);
        if (afterSaleDao.addAfterSale(aftersalesService) != null) {
            System.out.println("insert1: " + aftersalesService.getId());
        } else {
            System.out.println("insert1 error");
        }

        AftersalesService aftersalesService1 = new AftersalesService();
        aftersalesService1.setApplyTime(LocalDateTime.now());
        aftersalesService1.setId(92);
        aftersalesService1.setUserId(25);
        aftersalesService1.setBeDeleted(false);
        aftersalesService1.setNumber(6);
        aftersalesService1.setType(1);
        aftersalesService1.setApplyReason("Wow");
        aftersalesService1.setGoodsType(1);
        aftersalesService1.setBeApplied(false);
        if (afterSaleDao.addAfterSale(aftersalesService1) != null) {
            System.out.println("insert2: " + aftersalesService1.getId());
        } else {
            System.out.println("insert2 error");
        }
    }

    @Test
    public void selectByIdTest() {
        AftersalesService aftersalesService = afterSaleDao.selectAfterSaleById(6, 21);
        if (aftersalesService != null) {
            System.out.println("select1 error: " + aftersalesService.getId() + " " + aftersalesService.getApplyReason());
        } else{
            System.out.println("select1 ok");
        }

        AftersalesService aftersalesService1 = afterSaleDao.selectAfterSaleById(7, 25);
        if (aftersalesService1 != null) {
            System.out.println("select2 ok: " + aftersalesService1.getId() + " " + aftersalesService1.getApplyReason());
        } else{
            System.out.println("select2 error");
        }
    }

    @Test
    public void selectByUserIdTest() {
        List<AftersalesService> aftersalesServiceList = afterSaleDao.selectAfterSalesByUserId(23, 1, 10);
        if (aftersalesServiceList == null) {
            System.out.println("select by userId Error");
        }
        System.out.println("select by userId: " + aftersalesServiceList.size() + "\n");
        for (AftersalesService aftersalesService : aftersalesServiceList) {
            System.out.println(aftersalesService.getId() + " " + aftersalesService.getUserId()
                    + " " + aftersalesService.getBeDeleted() + " " + aftersalesService.getApplyReason());
        }
    }

    @Test
    public void selectByUserIdForAdminTest() {
        List<AftersalesService> aftersalesServiceList = afterSaleDao.selectAfterSalesByCondition(23, 1, 10);
        if (aftersalesServiceList == null) {
            System.out.println("select by userId For Admin Error");
        }
        System.out.println("select by userId For Admin: " + aftersalesServiceList.size() + "\n");
        for (AftersalesService aftersalesService : aftersalesServiceList) {
            System.out.println(aftersalesService.getId() + " " + aftersalesService.getUserId()
                    + " " + aftersalesService.getBeDeleted() + " " + aftersalesService.getApplyReason());
        }
    }

    @Test
    public void deleteByIdTest() {
        if (afterSaleDao.deleteAfterSaleById(7, 23) > 0) {
            System.out.println("delete error1");
        } else {
            System.out.println("delete ok1");
        }
        if (afterSaleDao.deleteAfterSaleById(7,21) > 0) {
            System.out.println("delete ok2");
        } else {
            System.out.println("delete error2");
        }
    }

    @Test
    public void updateById() {
        AftersalesService aftersalesService = new AftersalesService();
        aftersalesService.setId(9);
        aftersalesService.setApplyReason("break");
        aftersalesService.setType(0);
        aftersalesService.setNumber(1);
        if (afterSaleDao.updateAfterSaleById(7, 23, aftersalesService) != null) {
            System.out.println("update error");
        } else {
            System.out.println("update ok");
        }
    }

    @Test
    public void updateByIdForAdmin() {
        AftersalesService aftersalesService = new AftersalesService();
        aftersalesService.setStatusCode(2);
        aftersalesService.setApplyReason("aaaaaaa");
        AftersalesService aftersalesService1 = afterSaleDao.updateAfterSaleByIdForAdmin(9, aftersalesService);
        if (aftersalesService1 == null){
            System.out.println("update By Admin error");
        } else {
            System.out.println("update By Admin ok");
        }
    }
}
