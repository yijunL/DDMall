package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.mapper.OomallAddressMapper;
import xmu.oomall.util.Copyer;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author 3204
 * @Description: AddressDao
 * @create 2019/12/16 20:49
 */
@Repository
public class AddressDao {

    @Autowired
    private OomallAddressMapper oomallAddressMapper;


    public List<Address> getAddressList(Integer userId, Integer page, Integer limit)
    {
        return (List<Address>) PageCut.pageCut(oomallAddressMapper.findAllByUserIdAndBeDeletedLessThan(userId,1),page,limit);
    }

    public Address getAddress(Integer id){
        AddressPo addressPo=oomallAddressMapper.findAllById(id);
        return addresses(addressPo);
    }

    public AddressPo addAddress(AddressPo addressPo){
        //插入的po不能有id
        if(addressPo.getId()!=null) {
            return null;
        }
        if(addressPo.getGmtCreate()==null) {
            addressPo.setGmtCreate(LocalDateTime.now());
        }
        if(addressPo.getGmtModified() == null) {
            addressPo.setGmtModified(LocalDateTime.now());
        }
        oomallAddressMapper.insertSelective(addressPo);
        return addressPo;
    }

    public AddressPo updateAddress(Integer id,AddressPo addressPo){
        //id不允许有值，即不能修改id
        if(addressPo.getId()!=null) {
            return null;
        }
        addressPo.setGmtModified(LocalDateTime.now());
        oomallAddressMapper.updateById(addressPo,id);
        return addressPo;
    }

    public boolean deleteAddress(Integer id) {

        AddressPo addressPo=new AddressPo();
        addressPo.setGmtModified(LocalDateTime.now());
        addressPo.setBeDeleted(true);
        if(oomallAddressMapper.updateById(addressPo,id)==0) {
            return false;
        }
        else {
            return true;
        }
    }

    private Address addresses(AddressPo addressPo){
        Address address1 = new Address();
        return Copyer.copy(addressPo,address1)?address1:null;
    }

    public void resetDefaultAddress(Integer userId){
        oomallAddressMapper.updateBeDefaultByUserId(false,userId);
    }

}