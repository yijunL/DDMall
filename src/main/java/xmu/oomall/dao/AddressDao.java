package xmu.oomall.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.*;
import xmu.oomall.mapper.OomallAddressMapper;
import xmu.oomall.mapper.OomallCollectItemMapper;
import xmu.oomall.util.Copyer;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDao {

    @Autowired
    private OomallAddressMapper oomallAddressMapper;


    public List<AddressPo> getAddressList(Integer page, Integer limit) {
        return (List<AddressPo>) PageCut.pageCut(oomallAddressMapper.findAllById(1), page, limit);
    }

    public Address addAddress(Address address) {
        if (address.getId() != null)    //插入的po不能有id
            return null;
        address.setGmtCreate(LocalDateTime.now());
        oomallAddressMapper.insertSelective(address);
        return address;
    }


    public boolean deleteAddress(Integer id) {

        AddressPo addressPo = new AddressPo();
        addressPo.setGmtModified(LocalDateTime.now());
        addressPo.setBeDeleted(true);
        if (oomallAddressMapper.updateById(addressPo, id) == 0)  //没有更新任何元素
            return false;
        else
            return true;
    }

    /**
     * 将collectItemPo列表转换成collectItem列表
     *
     * @return collectItems
     */
//    private List<CollectItem> collectItemList(List<CollectItemPo> collectItemPos){
//        List<CollectItem> collectItems=new ArrayList<CollectItem>();
//        for(CollectItemPo collectItemPo:collectItemPos){
//            collectItems.add(collectItems(collectItemPo));
//        }
//        return collectItems;
//    }

    /**
     *将collectItemPo转换成collectItem
     *
     * @return collectItems
     */
//    private CollectItem collectItems(CollectItemPo collectItemPo){
//        CollectItem collectItem = new CollectItem();
//        return Copyer.Copy(collectItemPo,collectItem)?collectItem:null;
//    }
}