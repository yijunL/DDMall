package xmu.oomall.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

//    @Test
//    public void getAddressListTest(){
//        List<Address> addressList = addressService.getAddressList(1,1,1);
//        AddressPo addressPo = addressList.get(0);
//        assertEquals(addressPo.getId(),1);
//    }
//
//    @Test
//    public void addAddressTest(){
//        AddressPo addressPo = new AddressPo();
//        addressPo.setUserId(10);//domain中是String字段
//        addressPo.setCityId(100);
//        addressPo.setProvinceId(22);
//        addressPo.setCountyId(33);
//        addressPo.setAddressDetail("新疆维吾尔自治区乌鲁木齐市乌鲁木齐县");
//        addressPo.setMobile("13946325423");//错误的电话号码，只有9位（测试能不能插入成功）
//        addressPo.setPostalCode("830063");
//        addressPo.setConsignee("神无月");
//        addressPo.setBeDefault(true);
//        addressPo.setGmtCreate(LocalDateTime.now());
//        addressPo.setGmtModified(LocalDateTime.now());
//        addressService.addAddress(addressPo);
//    }
}
