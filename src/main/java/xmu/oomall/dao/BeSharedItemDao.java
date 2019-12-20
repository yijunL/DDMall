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

        if(beSharedItem.getId()!=null)
            return null;
        BeSharedItem  beSharedItem1=beSharedItemMapper.findByGoodsIdAndBeSharedUserIdAndSharerId(beSharedItem.getGoodsId(),
                beSharedItem.getBeSharedUserId(),beSharedItem.getSharerId());
        if(beSharedItem1!=null)
            return null;
        else{
            beSharedItem.setGmtCreate(LocalDateTime.now());
            beSharedItem.setGmtModified(LocalDateTime.now());
            beSharedItem.setBirthTime(LocalDateTime.now());
            beSharedItemMapper.insertSelective(beSharedItem);
            return beSharedItem;
        }

    }

    public  List<BeSharedItem> getValidBeShareItem(Integer beSharedUserId, List<OrderItem> orderItemList)
    {
        BeSharedItem beSharedItem=new BeSharedItem();
        List<BeSharedItem> list=new ArrayList<BeSharedItem>();
        list=null;
        for(OrderItemPo orderItemPo:orderItemList) {
             beSharedItem = beSharedItemMapper.findByGoodsIdAndBeSharedUserId(orderItemPo.getGoodsId(),beSharedUserId);
             if(beSharedItem!=null&&beSharedItem.getBirthTime().plusDays(7).isAfter(orderItemPo.getGmtCreate())&&
             beSharedItem.getStatusCode()==0)
                 beSharedItem.setGmtModified(LocalDateTime.now());
                 beSharedItemMapper.updateById(beSharedItem,beSharedItem.getId());
                 list.add(beSharedItem);
        }
        return list;
    }
}
