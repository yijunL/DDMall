package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;

    @Test
    public void getAddressListTest()
    {
        List<Address> addressList= addressDao.getAddressList(1,1,1);
        AddressPo addressPo = addressList.get(0);
        assertEquals(addressPo.getId(),1);
    }

    @Test
    public void updateAddressTest(){
        AddressPo addressPo=new AddressPo();
        addressPo.setMobile("000");
        addressPo=addressDao.updateAddress(1,addressPo);
        assertEquals(addressPo.getMobile(),"000");
    }

    @Test
    public void addAddressTest()
    {
        AddressPo addressPo=new AddressPo();
        addressPo.setBeDeleted(false);
        addressPo.setCityId(123);
        addressPo.setCountyId(123);
        addressPo.setProvinceId(123);
        addressPo.setAddressDetail("123");
        addressPo.setPostalCode("123");
        addressPo.setConsignee("123");
        addressPo.setMobile("123");
        addressPo.setUserId(3);
        addressPo=addressDao.addAddress(addressPo);
        assertEquals(addressPo.getUserId(),3);
    }

    @Test
    public void deleteAddressTest()
    {
        addressDao.deleteAddress(1);
        AddressPo addressPo=addressDao.getAddress(1);
        assertEquals(addressPo.getBeDeleted(),true);
    }
}
