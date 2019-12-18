package xmu.oomall.service;


import org.springframework.stereotype.Service;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;


import java.util.List;


@Service
public interface CollectionService {

    public List<CollectItem> getCollectionList(Integer userId, Integer page, Integer limit);

    public CollectItemPo addCollection(CollectItemPo collectItemPo);

    public boolean deleteCollection(Integer id);

}
