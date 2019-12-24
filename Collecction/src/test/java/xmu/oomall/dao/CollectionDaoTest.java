package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CollectionDaoTest {
    @Autowired
    private CollectionDao collectionDao;

    @Test
    public void getAllCollectionTest()
    {
        List<CollectItem> collectItemList= collectionDao.getColltectionList(1,1,1);
        CollectItemPo collectItemPo = collectItemList.get(0);
        assertEquals(5,collectItemPo.getId());
    }

    @Test
    public void addCollectionTest(){
        CollectItemPo collectItemPo= new CollectItemPo();
        collectItemPo.setUserId(1);
        collectItemPo.setGoodsId(3);
        collectItemPo = collectionDao.addCollection(collectItemPo);
        assertEquals(3,collectItemPo.getGoodsId());
    }

    @Test
    public void deleteCollectionTest()
    {

        assertEquals(false,collectionDao.deleteCollection(1));
    }
}
