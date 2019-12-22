package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.Order;
import xmu.oomall.domain.OrderItem;
import xmu.oomall.domain.OrderItemPo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
class BeSharedItemDaoTest {
    @Autowired
    private BeSharedItemDao beSharedItemDao;

    @Test
    void addBeSharedItems() {
        BeSharedItem beSharedItem=new BeSharedItem();
    //    beSharedItem.setBeDeleted(false);
        beSharedItem .setBeSharedUserId(1);
        beSharedItem.setGoodsId(11);
      //  beSharedItem.setStatusCode(0);
        beSharedItem.setSharerId(2);
        System.out.println("1"+beSharedItem.getGoodsId());
        BeSharedItem beSharedItem1=beSharedItemDao.addBeSharedItems(beSharedItem);

        System.out.println(beSharedItem1);

    }

    @Test
    void getValidBeShareItem() {
        Order order=new Order();
        order.setId(1);
        order.setUserId(1);
        OrderItem orderItemPo=new OrderItem();
        orderItemPo.setGoodsId(1);
        orderItemPo.setPrice(new BigDecimal(100));
        orderItemPo.setGmtCreate(LocalDateTime.now());
        List<OrderItem> orderItemList=new ArrayList<OrderItem>();
        orderItemList.add(orderItemPo);
       // order.setOrderItemList(orderItemList);
        Integer beSharedId=1;
        List<BeSharedItem> beSharedItemList=new ArrayList<BeSharedItem>();
        beSharedItemList=beSharedItemDao.getValidBeShareItem(beSharedId,orderItemList);
    }
}