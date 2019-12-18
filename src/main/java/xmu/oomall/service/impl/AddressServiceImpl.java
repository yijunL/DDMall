package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.dao.CollectionDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.AddressService;
import xmu.oomall.service.CollectionService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<AddressPo> getAddressList(Integer page, Integer limit){
        return addressDao.getAddressList(page, limit);
    };

    @Override
    public Address addAddress(Address address){
        return addressDao.addAddress(address);
    }

//    @Override
//    public CollectItemPo addCollection(CollectItemPo collectItemPo){
//
//        return collectionDao.addCollection(collectItemPo);
//    };


    @Override
    public boolean deleteAddress (Integer id){
        return addressDao.deleteAddress(id);
    };



}