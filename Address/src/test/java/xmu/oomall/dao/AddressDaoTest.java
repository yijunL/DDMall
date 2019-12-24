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
        assertEquals(1,addressPo.getId());
    }

    @Test
    public void getAddressTest(){
        Address address = addressDao.getAddress(1);
        assertEquals(1,address.getUserId());
    }

    @Test
    public void updateAddressTest(){
        AddressPo addressPo=new AddressPo();
        addressPo.setMobile("000");
        addressPo=addressDao.updateAddress(1,addressPo);
        assertEquals("000",addressPo.getMobile());
    }

    @Test
    public void addAddressTest()
    {
        AddressPo addressPo=new AddressPo();
        addressPo.setBeDeleted(false);
        addressPo.setCityId(123);
        addressPo.setCountyId(123);
        addressPo.setProvinceId(123);
        addressPo.setAddressDetail("思明区思明南路144号");
        addressPo.setPostalCode("123");
        addressPo.setConsignee("123");
        addressPo.setMobile("123");
        addressPo.setUserId(2);
        addressPo=addressDao.addAddress(addressPo);
        assertEquals(2,addressPo.getUserId());
    }

    @Test
    public void deleteAddressTest()
    {
        addressDao.deleteAddress(1);
        AddressPo addressPo=addressDao.getAddress(1);
        assertEquals(true,addressPo.getBeDeleted());
    }

}
