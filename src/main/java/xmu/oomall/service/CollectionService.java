package xmu.oomall.service;


import org.springframework.stereotype.Service;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;


import java.util.List;


@Service
public interface CollectionService {
    /**
     *
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    public List<CollectItem> getCollectionList(Integer userId, Integer page, Integer limit);

    /**
     *
     * @param collectItemPo
     * @return
     */
    public CollectItemPo addCollection(CollectItemPo collectItemPo);

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteCollection (Integer id);


}
