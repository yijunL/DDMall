package xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.*;
import xmu.oomall.mapper.OomallFootprintMapper;
import xmu.oomall.util.Copyer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintDao
 * @create 2019/12/14 13:30
 */
@Repository
public class FootprintDao {
    @Autowired
    private OomallFootprintMapper oomallFootprintMapper;

    /**
     * 用户获取足迹列表
     *
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> selectByUserId(Integer page, Integer limit) {
        PageHelper.startPage(page, limit); //use page-helper
        Integer userId = 1; //从网关获取用户id
        List<FootprintItemPo> footprintItemPos = oomallFootprintMapper.selectAllByUserId(userId); //
        List<FootprintItem> footprintItems = footprintItemList(footprintItemPos);
        return footprintItems;
    }

    /**
     * 用户删除足迹（弃用）
     *
     * @param id：Integer
     * @return 0 or 1
     */
    public int deleteFootprintById (Integer id) {
        return oomallFootprintMapper.deleteById(id);
    }

    /**
     * 管理员查看足迹
     *
     * @param userId: Integer
     * @param goodsId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> selectByCondition(Integer userId, Integer goodsId, Integer page, Integer limit) { //need to be updated
        /* 判断userId与goodsId是否合法 */
        System.out.println("userId: " + userId + " and goodsId: " + goodsId); //
        PageHelper.startPage(page, limit);
        List<FootprintItemPo> footprintItemPos = oomallFootprintMapper.selectByCondition(userId, goodsId);
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
        footprintItemPo.setUserId(userId); //是否需要赋值？
        footprintItemPo.setGmtCreate(LocalDateTime.now()); //
        if(footprintItemPo.getId() != null) {
            if(oomallFootprintMapper.selectAllById(footprintItemPo.getId()) != null) { //已存在，插入不合法
                return null;
            }
        }
        if (oomallFootprintMapper.insertSelective(footprintItemPo) > 0)
            return footprintItemPo;
        else return null;
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
