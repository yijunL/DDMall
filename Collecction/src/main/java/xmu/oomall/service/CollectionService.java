package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;

import java.util.List;

/**
 * @author Lyj
 */
@Service
public interface CollectionService {
    /**
     * 获取某用户的收藏夹列表的service层接口
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    public List<CollectItem> getCollectionList(Integer userId, Integer page, Integer limit);

    /**
     * 添加收藏
     * @param collectItemPo
     * @return
     */
    public CollectItemPo addCollection(CollectItemPo collectItemPo);

    /**
     * 删除收藏
     * @param id
     * @return
     */
    public boolean deleteCollection(Integer id);

}
