package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.mapper.OomallCollectItemMapper;

@Repository
public class CollectionDao {

    @Autowired
    private OomallCollectItemMapper collectionMapper;



    //删除收藏
    public void deleteCollection(Integer id) {
        collectionMapper.deleteById(id);
    }
}