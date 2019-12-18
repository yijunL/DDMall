package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.util.Copyer;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AddressControllerTest {
    @Autowired
    private AddressController addressController;
    @Autowired
    private AddressDao addressDao;


    @Test
    public void deleteAddressTest()
    {
        addressController.deleteAddress(1);
        AddressPo addressPo=addressDao.getAddressList(1,1).get(0);
        assertEquals(addressPo.getBeDeleted(),true);
    }

//
//    @Test
//    public void getAllAddressTest()
//    {
//        HttpServletRequest request;
//
//        List<AddressPo> addressPoList= addressController.getAddressList(1,1);
//        assertEquals(addressPoList.get(0).getUserId(),1);
//    }




}