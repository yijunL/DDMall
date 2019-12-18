package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.CollectItemPo;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CollectionControllerTest {
    @Autowired
    private CollectionController collectionController;

//    @Test
////    public void deleteCollectionTest()
////    {
////
////        collectionController.deleteCollection(1);
////    }


    @Test
    public void addCollectionTest()
    {
        CollectItemPo collectItemPo=new CollectItemPo();
        collectItemPo.setUserId(2);
        collectItemPo.setGoodsId(2);
        collectItemPo=collectionController.addCollection(collectItemPo);
        assertEquals(collectItemPo.getUserId(),2);
    }

}