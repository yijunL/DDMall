package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.domain.DefaultFreightPo;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Transactional
public class AddressControllerTest {
    @Autowired
    private AddressController addressController;
    @Autowired
    private AddressDao addressDao;

//    @Test
//    public void deleteAddress()
//    {
//        addressController.deleteAddress(1);
//        assertEquals(addressDao.getAddressList(1,1).get(0).getBeDeleted(),true);
//    }
//
//    @Test
//    public void getAllAddressTest()
//    {
//        List<AddressPo> addressPoList= addressController.getAddressList(1,1);
//        assertEquals(addressPoList.get(0).getUserId(),1);
//    }

    @Test
    public void addAddress()
    {
        Address address=new Address();
        address.setCity("成都");
        address.setCounty("中国");
        address.setProvince("四川");
        address.setBeDeleted(false);
        address.setCityId(123);
        address.setCountyId(123);
        address.setProvinceId(123);
        address.setAddressDetail("123");
        address.setPostalCode("123");
        address.setConsignee("123");
        address.setMobile("123");
        address.setUserId(2);
        addressController.addAddress(address);
//        assertEquals(address.getId(),2);
    }

}