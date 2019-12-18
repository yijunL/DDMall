package xmu.oomall.service;


import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;


import java.util.List;


@Service
public interface AddressService {

    public List<AddressPo> getAddressList(Integer page, Integer limit);

    public Address addAddress(Address address);

    //    public CollectItemPo addCollection(CollectItemPo collectItemPo);
//
    public boolean deleteAddress(Integer id);

}
