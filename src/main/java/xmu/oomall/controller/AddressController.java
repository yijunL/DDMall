package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.dao.CollectionDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.AddressService;
import xmu.oomall.service.CollectionService;
import xmu.oomall.util.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping("addressService")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 用户查询地址信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/addresses")
    public List<AddressPo> getAddressList(@RequestParam Integer page, @RequestParam Integer limit) {
        return addressService.getAddressList(page, limit);
    }


    @PostMapping("/addresses")
    public Object addAddress(@RequestBody Address address)
    {
        if(address==null)
            return ResponseUtil.badArgument();
        Address address1=addressService.addAddress(address);

        if(address==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(address1);
    }

    /**
     * 用户删除某个地址详情
     * @param id
     * @return
     */
    @DeleteMapping("/addresses/{id}")
    public Object deleteAddress(@PathVariable Integer id){
        if(id==null)
            return ResponseUtil.badArgument();
        if(addressService.deleteAddress(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }
}
