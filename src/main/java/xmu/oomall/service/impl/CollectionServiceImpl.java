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

    @Override
    public List<CollectItem> getCollectionList(Integer userId, Integer page, Integer limit){
      return null;
    };

    @Override
    public CollectItemPo addCollection(CollectItemPo collectItemPo){
        return null;
    };

    @Override
    public void deleteCollection (Integer id){
        collectionDao.deleteCollection(id);
    };



}