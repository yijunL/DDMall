package xmu.oomall.service;

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
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void getAddressListTest(){
        List<Address> addressList = addressService.getAddressList(1,1,1);
        AddressPo addressPo = addressList.get(0);
        assertEquals(addressPo.getId(),1);
    }
}
