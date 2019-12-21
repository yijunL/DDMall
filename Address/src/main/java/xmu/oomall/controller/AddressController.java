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
@RequestMapping("/addressService")
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
//     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/addresses")
    public Object getAddressList(HttpServletRequest request, @RequestParam Integer page, @RequestParam Integer limit) {
        Integer userId=getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        // 参数校验
        if (page == null || page <= 0) {
            return ResponseUtil.fail(744,"该地址是无效地址");
        }
        if (limit == null || limit <= 0) {
            return ResponseUtil.fail(744,"该地址是无效地址");
        }
        List<Address> addressList=addressService.getAddressList(userId, page, limit);
        return ResponseUtil.ok(addressList);
    }

    /**
     * 用户查看某个地址详情
     * @param id
     * @return
     */
    @GetMapping("/addresses/{id}")
    public Object getAddress(HttpServletRequest request, @PathVariable Integer id) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        // 参数校验
        if (id == null || id < 0) {
            return ResponseUtil.fail(744,"该地址是无效地址");
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
    public Object addAddress(HttpServletRequest request, @RequestBody AddressPo addressPo)
    {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        //参数校验
        if((addressPo.getCountyId()==null)||(addressPo.getProvinceId()==null)||(addressPo.getCityId()==null)||
                (addressPo.getAddressDetail()==null)||(addressPo.getPostalCode()==null)||
                (addressPo.getConsignee()==null)||(addressPo.getMobile()==null)||(addressPo.getUserId()==null)) {
            return ResponseUtil.fail(751,"地址新增失败");
        }
        AddressPo addressPo1=addressService.addAddress(addressPo);
        if(addressPo1==null)
            return ResponseUtil.fail(751,"地址新增失败");
        else
            return ResponseUtil.ok(addressPo1);
    }

    /**
     * 用户修改某个地址详情
     * @param id
     * @param addressPo
     * @return
     */
    @PutMapping("/addresses/{id}")
    public Object updateAddress(HttpServletRequest request, @PathVariable Integer id,@RequestBody AddressPo addressPo){

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        //参数校验
        if((addressPo.getCountyId()==null)||(addressPo.getProvinceId()==null)||(addressPo.getCityId()==null)||
                (addressPo.getAddressDetail()==null)||(addressPo.getPostalCode()==null)||
                (addressPo.getConsignee()==null)||(addressPo.getMobile()==null)||(addressPo.getUserId()==null)) {
            return ResponseUtil.fail(752,"地址修改失败");
        }
        if(id==null || id < 0){
            return ResponseUtil.fail(752,"地址修改失败");
        }
        AddressPo addressPo1=addressService.updateAddress(id,addressPo);
        if(addressPo1==null)
            return ResponseUtil.fail(752,"地址修改失败");
        else
            return ResponseUtil.ok(addressPo1);
    }

    /**
     * 用户删除某个地址详情
     * @param id
     * @return
     */
    @DeleteMapping("/addresses/{id}")
    public Object deleteAddress(HttpServletRequest request, @PathVariable Integer id){
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }

        // 参数校验
        if (id == null || id < 0) {
            return ResponseUtil.fail(743,"地址删除失败");
        }
        if(addressService.deleteAddress(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.fail(743,"地址删除失败");
    }
}
