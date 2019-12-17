package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.service.CollectionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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
    public void getAllCollectionTest()
    {
        List<CollectItemPo> collectItemList= collectionController.getCollectionList(1,1,1);
        assertEquals(collectItemList.get(0).getUserId(),1);
    }

}