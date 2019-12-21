package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.Order;
import xmu.oomall.domain.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ShareItemDaoTest {

    @Autowired
    private ShareItemDao shareItemDao;
    @Autowired
    private BeSharedItemDao beSharedItemDao;


    @Test
    void calculate() {
        int[] lowerbound={10,20};
        int[] upperbound={19,29};
        double[] rate={0.8,0.9};
        Integer sucessnum=2000;
        BigDecimal bigDecimal=new BigDecimal(100);
        Integer validnum=100;
        Integer sum=shareItemDao.Calculate(sucessnum,bigDecimal,validnum,lowerbound, upperbound,rate);

        System.out.println(sum);

    }

    @Test
    void updateShareItemSuccessNumAndCalculate() {
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
        BigDecimal bigDecimal=new BigDecimal(100);
        Integer s=shareItemDao.updateShareItemSuccessNumAndCalculate(beSharedItemList,bigDecimal);
        System.out.println(s);

    }
}