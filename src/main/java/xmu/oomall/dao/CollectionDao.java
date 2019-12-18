package xmu.oomall.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.mapper.OomallCollectItemMapper;
import xmu.oomall.util.Copyer;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CollectionDao {

    @Autowired
    private OomallCollectItemMapper oomallCollectItemMapper;


    /**
     * 用户查看收藏列表
     *
     * @param userId:       Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<CollectItem>
     */
    public List<CollectItemPo> getColltectionList(Integer userId, Integer page, Integer limit) {
        return (List<CollectItemPo>) PageCut.pageCut(oomallCollectItemMapper.findAllById(userId), page, limit);
    }

    public CollectItemPo addCollection(CollectItemPo collectItemPo) {
        if (collectItemPo.getId() != null)
            return null;
        collectItemPo.setGmtCreate(LocalDateTime.now());
        oomallCollectItemMapper.insertSelective(collectItemPo);

        return collectItemPo;
    }

    /**
     * 用户删除收藏
     *
     * @param id：Integer
     * @return null
     */
    public boolean deleteCollection(Integer id) {

        return oomallCollectItemMapper.deleteById(id);
    }

    /**
     * 将collectItemPo列表转换成collectItem列表
     *
     * @return collectItems
     */
    private List<CollectItem> collectItemList(List<CollectItemPo> collectItemPos) {
        List<CollectItem> collectItems = new ArrayList<CollectItem>();
        for (CollectItemPo collectItemPo : collectItemPos) {
            collectItems.add(collectItems(collectItemPo));
        }
        return collectItems;
    }

    /**
     * 将collectItemPo转换成collectItem
     *
     * @return collectItems
     */
    private CollectItem collectItems(CollectItemPo collectItemPo) {
        CollectItem collectItem = new CollectItem();
        return Copyer.Copy(collectItemPo, collectItem) ? collectItem : null;
    }
}