package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.CollectionDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.CollectionService;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionDao collectionDao;

    /**
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<CollectItemPo> getCollectionList(Integer userId, Integer page, Integer limit) {
        return collectionDao.getColltectionList(userId, page, limit);
    }

    ;

    /**
     * @param collectItemPo
     * @return
     */
    @Override
    public CollectItemPo addCollection(CollectItemPo collectItemPo) {

        return collectionDao.addCollection(collectItemPo);
    }

    ;

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteCollection(Integer id) {
        return collectionDao.deleteCollection(id);
    }

    ;


}