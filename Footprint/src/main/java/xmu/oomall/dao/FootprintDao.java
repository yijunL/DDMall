package xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
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
     * @param userId: Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> selectByUserId(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<FootprintItemPo> footprintItemPos = oomallFootprintMapper.selectAllByUserId(userId);
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
        PageHelper.startPage(page, limit);
        if(userId == null && goodsId == null) {
            List<FootprintItemPo> footprintItemPos = oomallFootprintMapper.selectAll();
            List<FootprintItem> footprintItems = footprintItemList(footprintItemPos);
            return footprintItems;
        }
        else {
            List<FootprintItemPo> footprintItemPos = oomallFootprintMapper.selectByCondition(userId, goodsId);
            List<FootprintItem> footprintItems = footprintItemList(footprintItemPos);
            return footprintItems;
        }
    }

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    public FootprintItemPo addFootprint(FootprintItemPo footprintItemPo) {
        if(footprintItemPo.getGoodsId() == null
            || footprintItemPo.getUserId() == null) {
            return null;
        }
        LocalDateTime time = LocalDateTime.now();
        footprintItemPo.setGmtCreate(time);
        footprintItemPo.setBirthTime(time);
        if (oomallFootprintMapper.insertSelective(footprintItemPo) > 0) {
            return footprintItemPo;
        } else {
            return null;
        }
    }

    /**
     * 将FootprintItemPo对象转换为FootprintItem
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItem
     */
    private FootprintItem footprintItem(FootprintItemPo footprintItemPo) {
        FootprintItem footprintItem = new FootprintItem();
        return Copyer.copy(footprintItemPo, footprintItem) ? footprintItem : null;
    }

    /**
     * 将List<FootprintItemPo>转换为List<FootprintItem>
     *
     * @param footprintItemPoList: FootprintItemPo
     * @return FootprintItem
     */
    private List<FootprintItem> footprintItemList(List<FootprintItemPo> footprintItemPoList) {
        if (footprintItemPoList == null ) {
            return null;
        }
        List<FootprintItem> footprintItemList = new ArrayList<>();
        for(FootprintItemPo footprintItemPo : footprintItemPoList) {
            footprintItemList.add(footprintItem(footprintItemPo));
        }
        return footprintItemList;
    }
}
