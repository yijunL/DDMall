package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.UserValidate;
import xmu.oomall.dao.CollectionDao;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.service.CollectionService;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionDao collectionDao;
    @Autowired
    private UserValidate userValidate;

    @Override
    public List<CollectItem> getCollectionList(Integer userId,Integer page, Integer limit){
        if(!userValidate.validate(userId))
            return null;
        return collectionDao.getColltectionList(userId,page, limit);
    };

    @Override
    public CollectItemPo addCollection(CollectItemPo collectItemPo){

        return collectionDao.addCollection(collectItemPo);
    };

    @Override
    public boolean deleteCollection (Integer id){
        return collectionDao.deleteCollection(id);
    };

}