package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.UserValidate;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.service.AddressService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserValidate userValidate;

    @Override
    public List<Address> getAddressList(Integer userId, Integer page, Integer limit){
//        if(!userValidate.validate(userId))
//            return null;
        return addressDao.getAddressList(userId, page, limit);
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

    @Override
    public void resetDefaultAddress(Integer userId){
        addressDao.resetDefaultAddress(userId);
    }

//    public void resetDefaultAddress(Integer userId) {
//        Address address = new Address();
//        address.setBeDefault(false);
//        address.setGmtModified(LocalDateTime.now());
//        LitemallAddressExample example = new LitemallAddressExample();
//        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
//        addressMapper.updateByExampleSelective(address, example);
//    }

}