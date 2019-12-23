package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.FootprintDao;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

@SpringBootTest
//@Transactional //
public class FootprintDaoTest {
//    @Autowired
//    private FootprintDao footprintDao;
//
//    @Test
//    public void addFootprintTest() {
//        FootprintItemPo footprintItemPo = new FootprintItemPo();
//        footprintItemPo.setId(23);
//        footprintItemPo.setUserId(12);
//        footprintItemPo.setGoodsId(97);
//        footprintDao.addFootprint(footprintItemPo);
//
//        FootprintItemPo footprintItemPo1 = new FootprintItemPo();
//        footprintItemPo1.setId(3);
//        footprintItemPo1.setUserId(19);
//        footprintItemPo1.setGoodsId(24);
//        footprintDao.addFootprint(footprintItemPo1);
//    }
//
//    @Test
//    public void selectFootprintTest() {
//        List<FootprintItem> footprintItemList1 = footprintDao.selectByUserId(12, 1, 10),
//                footprintItemList2 = footprintDao.selectByUserId(11, 1, 10);
//        if (footprintItemList1 == null) {
//            System.out.println("null1");
//        } else {
//            System.out.println(footprintItemList1.size());
//        }
//        System.out.println("Board");
//        if (footprintItemList2 == null) {
//            System.out.println("null2");
//        } else {
//            System.out.println(footprintItemList2.size());
//        }
//    }
//
//    @Test
//    public void selectFootprintByConditionTest() {
//        List<FootprintItem> footprintItemList1 = footprintDao.selectByCondition(12, 96,1, 10),
//                footprintItemList2 = footprintDao.selectByCondition(19, 97, 1, 10);
//        if (footprintItemList1 == null) {
//            System.out.println("null1");
//        } else {
//            for (FootprintItem footprintItem : footprintItemList1) {
//                System.out.println(footprintItem.getId());
//            }
//        }
//        System.out.println("Board");
//        if (footprintItemList2 == null) {
//            System.out.println("null2");
//        } else {
//            for (FootprintItem footprintItem : footprintItemList2) {
//                System.out.println(footprintItem.getId());
//            }
//        }
//    }
}