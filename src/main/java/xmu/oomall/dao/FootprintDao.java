package xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.*;
import xmu.oomall.mapper.FootprintMapper;
import xmu.oomall.util.Copyer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintDAO
 * @create 2019/12/14 13:30
 */
@Repository
public class FootprintDao {
    @Autowired
    private FootprintMapper footprintMapper;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> selectByUserId(Integer page, Integer limit) {
        PageHelper.startPage(page, limit); //use page-helper
        List<FootprintItemPo> footprintItemPos = footprintMapper.select();
        List<FootprintItem> footprintItems = footprintItemList(footprintItemPos);
        return footprintItems;
    }

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    public boolean deleteFootprintById (Integer id) {
        return (footprintMapper.deleteByUserId(id) == 1);
    }

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItem>
     */
    public List<FootprintItem> selectByCondition() { //need to be updated
        List<FootprintItemPo> footprintItemPos = footprintMapper.selectByCondition("1", "1");
        List<FootprintItem> footprintItems = footprintItemList(footprintItemPos);
        return footprintItems;
    }

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param userId: Integer
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    public FootprintItemPo addFootprint(Integer userId, FootprintItemPo footprintItemPo) { //需在controller层进行合法性判断
        footprintItemPo.setUserId(userId);
        if (footprintMapper.insertSelective(footprintItemPo) > 0) return footprintItemPo;
        else return  null;
    }

    /**
     * 将FootprintItemPo对象转换为FootprintItem
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItem
     */
    private FootprintItem footprintItem(FootprintItemPo footprintItemPo) {
        FootprintItem footprintItem = new FootprintItem();
        return Copyer.Copy(footprintItemPo, footprintItem) ? footprintItem : null;
    }

    /**
     * 将List<FootprintItemPo>转换为List<FootprintItem>
     *
     * @param footprintItemPoList: FootprintItemPo
     * @return FootprintItem
     */
    private List<FootprintItem> footprintItemList(List<FootprintItemPo> footprintItemPoList) {
        if(footprintItemPoList == null){
            return null;
        }
        List<FootprintItem> footprintItemList = new ArrayList<>();
        for(FootprintItemPo footprintItemPo : footprintItemPoList) {
            footprintItemList.add(footprintItem(footprintItemPo));
        }
        return footprintItemList;
    }
}
