package xmu.oomall.service;


import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;

import java.util.List;

@Service
public interface AddressService {

    public List<Address> getAddressList(Integer usrId,Integer page, Integer limit);

    public Address getAddress(Integer id);

    public AddressPo addAddress(AddressPo addressPo);

    public AddressPo updateAddress(Integer id, AddressPo addressPo);

    public boolean deleteAddress(Integer id);

    public void resetDefaultAddress(Integer userId);

}
