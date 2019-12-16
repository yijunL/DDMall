package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;
import xmu.oomall.service.CollectionService;


import java.util.List;

@RestController
@RequestMapping("collectionService")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 用户查看收藏列表
     *
     * @param userId: Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<CollectItem>
     */
    @GetMapping("/collections")
    public Object getCollectionList(@RequestParam Integer userId,@RequestParam Integer page,
                                           @RequestParam Integer limit) {
        List<CollectItem> collectItemList=collectionService.getCollectionList(userId,page,limit);
        return collectItemList;
    }

    /**
     * 用户添加收藏
     *
     * @param collectItemPo: CollectItemPo
     * @return collectItemPo
     */
    @PostMapping("/collections")
    public Object addCollection(@RequestBody CollectItemPo collectItemPo) {
        return null;
    }

    /**
     * 用户删除收藏
     *
     * @param id：Integer
     * @return null
     */
    @DeleteMapping("/collections/{id}")
    public void deleteCollection (@PathVariable Integer id) {
        collectionService.deleteCollection(id);
    }

}
