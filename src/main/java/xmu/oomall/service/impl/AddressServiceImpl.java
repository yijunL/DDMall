package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAddressList(Integer page, Integer limit){
        return addressDao.getAddressList(page, limit);
    };

    @Override
    public Address getAddress(Integer id){
        return addressDao.getAddress(id);
    }

    @Override
    public AddressPo addAddress(AddressPo addressPo){
        return addressDao.addAddress(addressPo);
    }

    @Override
    public AddressPo updateAddress(Integer id,AddressPo addressPo){
        return addressDao.updateAddress(id,addressPo);
    }

    @Override
    public boolean deleteAddress (Integer id){
        return addressDao.deleteAddress(id);
    };



}