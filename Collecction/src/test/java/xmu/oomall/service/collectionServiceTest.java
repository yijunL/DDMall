package xmu.oomall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.CollectItemPo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class collectionServiceTest {
    @Autowired
    private CollectionService collectionService;

    public void test_1()
    {
        CollectItemPo collectItemPo= new CollectItemPo();
        collectItemPo.setUserId(1);
        collectItemPo.setGoodsId(3);
        collectItemPo= collectionService.addCollection(collectItemPo);
        assertEquals(3,collectItemPo.getGoodsId());

    }
    public void test_2()
    {
        assertEquals(true,collectionService.deleteCollection(6));
    }


}