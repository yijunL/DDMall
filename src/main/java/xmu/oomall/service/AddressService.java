package xmu.oomall.service;


import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;


import java.util.List;


@Service
public interface AddressService {

    public List<Address> getAddressList(Integer page, Integer limit);

    public Address getAddress(Integer id);

    public AddressPo addAddress(AddressPo addressPo);

    public Address updateAddress(Integer id,Address address);

    public boolean deleteAddress (Integer id);

}
