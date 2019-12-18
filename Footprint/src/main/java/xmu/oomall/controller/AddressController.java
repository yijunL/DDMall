package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.service.AddressService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("addressService")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 解析请求
     * @param request
     * @return
     */
    private Integer getUserId(HttpServletRequest request) {
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null) {
            return null;
        }
        return Integer.valueOf(userIdStr);
    }

    /**
     * 用户查询所有地址信息
     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/addresses")
    public Object getAddressList(HttpServletRequest request,@RequestParam Integer page, @RequestParam Integer limit) {
        Integer userId=getUserId(request);
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        // 参数校验
        if (page == null || page < 0) {
            return ResponseUtil.badArgumentValue();
        }
        if (limit == null || limit < 0) {
            return ResponseUtil.badArgumentValue();
        }
        List<Address> addressList=addressService.getAddressList(page, limit);
        return ResponseUtil.ok(addressList);
    }

    /**
     * 用户查看某个地址详情
     * @param id
     * @return
     */
    @GetMapping("/addresses/{id}")
    public Object getAddress(@PathVariable Integer id) {
        if (id == null) {
            return ResponseUtil.badArgument();
        }
       Address address = addressService.getAddress(id);
        return ResponseUtil.ok(address);
    }

    /**
     *用户增加常用地址
     * @param addressPo
     * @return
     */
    @PostMapping("/addresses")
    public Object addAddress(@RequestBody AddressPo addressPo)
    {
        if(addressPo==null)
            return ResponseUtil.badArgument();
        AddressPo addressPo1=addressService.addAddress(addressPo);

        if(addressPo==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(addressPo1);
    }

    /**
     * 用户修改某个地址详情
     * @param id
     * @param address
     * @return
     */
    @PutMapping("/addresses/{id}")
    public Object updateAddress(@PathVariable Integer id,@RequestBody Address address){

        if(id==null || address==null)
            return ResponseUtil.badArgument();
        Address address1=addressService.updateAddress(id,address);
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
