package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.BeSharedItem;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class BeSharedItemDaoTest {
    @Autowired
    private BeSharedItemDao beSharedItemDao;

    @Test
    void addBeSharedItems() {
        BeSharedItem beSharedItem=new BeSharedItem();
        beSharedItem.setBeDeleted(false);
        beSharedItem .setBeSharedUserId(1);
        beSharedItem.setGoodsId(1);
        beSharedItem.setStatusCode(0);
        beSharedItem.setSharerId(2);
        BeSharedItem beSharedItem1=(BeSharedItem)beSharedItemDao.addBeSharedItems(beSharedItem);
        assertEquals(1,beSharedItem1.getGoodsId());
    }
}