package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.OrderItem;
import xmu.oomall.domain.OrderItemPo;
import xmu.oomall.mapper.OomallBeSharedItemMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BeSharedItemDao {
    @Autowired
    private OomallBeSharedItemMapper beSharedItemMapper;
    public BeSharedItem addBeSharedItems(BeSharedItem beSharedItem) {

        BeSharedItem  beSharedItem1=beSharedItemMapper.findByGoodsIdAndBeSharedUserIdAndSharerId(beSharedItem.getGoodsId(),
                beSharedItem.getBeSharedUserId(),beSharedItem.getSharerId());
        if(beSharedItem1!=null&&beSharedItem1.getBeDeleted()!=false)
            return null;
        else{
               beSharedItem.setBirthTime(LocalDateTime.now());
                beSharedItem.setGmtCreate(LocalDateTime.now());
                beSharedItem.setGmtModified(LocalDateTime.now());

            beSharedItemMapper.insertSelective(beSharedItem);
            return beSharedItem;
        }

    }

    public  List<BeSharedItem> getValidBeShareItem(Integer beSharedUserId, List<OrderItem> orderItemList)
    {
        BeSharedItem beSharedItem=new BeSharedItem();
        List<BeSharedItem> list=new ArrayList<BeSharedItem>();

        for(OrderItem orderItem:orderItemList) {
             beSharedItem = beSharedItemMapper.findByGoodsIdAndBeSharedUserId(orderItem.getGoodsId(),beSharedUserId);
            System.out.println( beSharedItem);
            System.out.println(1);
             if(beSharedItem!=null)
                 if(beSharedItem.getStatusCode()==0)
                   if((beSharedItem.getGmtCreate().plusDays(7)).isAfter(orderItem.getGmtCreate()))
             {
                 beSharedItem.setGmtModified(LocalDateTime.now());
                 beSharedItem.setStatusCode(1);
                 beSharedItemMapper.updateById(beSharedItem,beSharedItem.getId());
                 System.out.println("111");
                 list.add(beSharedItem);

             }
        }
        return list;
    }
}
