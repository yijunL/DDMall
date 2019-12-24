package xmu.oomall.service;


import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;

import java.util.List;

/**
 * @Author 3204
 * @Description: AddressService
 * @create 2019/12/16 20:49
 */
@Service
public interface AddressService {
    /**
     * 用户获取地址列表
     * @param usrId
     * @param page
     * @param limit
     * @return
     */
    public List<Address> getAddressList(Integer usrId,Integer page, Integer limit);

    /**
     * 用户获取某个地址详情
     * @param id
     * @return
     */
    public Address getAddress(Integer id);

    /**
     * 用户增加某个常用地址
     * @param addressPo
     * @return
     */
    public AddressPo addAddress(AddressPo addressPo);

    /**
     * 用户修改某个地止
     * @param id
     * @param addressPo
     * @return
     */
    public AddressPo updateAddress(Integer id, AddressPo addressPo);

    /**
     * 用户删除某个地址
     * @param id
     * @return
     */
    public boolean deleteAddress(Integer id);

    /**
     * 重置默认地址
     * @param userId
     */
    public void resetDefaultAddress(Integer userId);

}
