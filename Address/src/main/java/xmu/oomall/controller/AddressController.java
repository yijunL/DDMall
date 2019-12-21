package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.service.AddressService;
import xmu.oomall.util.RegexUtil;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
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
        if(address == null){
            return ResponseUtil.fail(744,"该地址是无效地址");
        }
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
        Object error = validate(addressPo);
        if (error != null) {
            return error;
        }
        if(addressPo.getGmtCreate() == null){
            addressPo.setGmtCreate(LocalDateTime.now());
        }
        if(addressPo.getBeDefault()){
            addressService.resetDefaultAddress(userId);
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
        Object error = validate(addressPo);
        if (error != null) {
            return error;
        }
        if(id==null || id < 0){
            return ResponseUtil.fail(752,"所修改地址不存在");
        }
        if(addressPo.getGmtModified() == null){
            addressPo.setGmtModified(LocalDateTime.now());
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
            return ResponseUtil.fail(743,"所删除的地址不存在");
        }
        if(addressService.deleteAddress(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.fail(743,"地址删除失败");
    }

    //合法性检测
    private Object validate(AddressPo addressPo) {

        Integer userId = addressPo.getUserId();
        if(StringUtils.isEmpty(userId)){
            return ResponseUtil.fail(751,"用户Id不能为空");
        }

        String name = addressPo.getConsignee();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.fail(751,"收货人不能为空");
        }

        // 测试收货手机号码是否正确
        String mobile = addressPo.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return ResponseUtil.fail(751,"电话号码不能为空");
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return ResponseUtil.fail(751,"电话号码错误");
        }

        Integer provinceId = addressPo.getProvinceId();
        if (StringUtils.isEmpty(provinceId)) {
            return ResponseUtil.fail(751,"省份不能为空");
        }

        Integer cityId = addressPo.getCityId();
        if (StringUtils.isEmpty(cityId)) {
            return ResponseUtil.fail(751,"城市不能为空");
        }

        Integer countyId = addressPo.getCountyId();
        if (StringUtils.isEmpty(countyId)) {
            return ResponseUtil.fail(751,"县/镇/区不能为空");
        }

        String areaCode = addressPo.getPostalCode();
        if (StringUtils.isEmpty(areaCode)) {
            return ResponseUtil.fail(751,"邮编不能为空");
        }

        String detailedAddress = addressPo.getAddressDetail();
        if (StringUtils.isEmpty(detailedAddress)) {
            return ResponseUtil.fail(751,"地址细节不能为空");
        }

        Boolean isDefault = addressPo.getBeDefault();
        if (isDefault == null) {
            return ResponseUtil.fail(751,"默认地址不能为空");
        }
        return null;
    }
}
