package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.dao.CollectionDao;
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
     * @param userId:       Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<CollectItem>
     */
    @GetMapping("/collections")
    public List<CollectItemPo> getCollectionList(@RequestParam Integer userId, @RequestParam Integer page,
                                                 @RequestParam Integer limit) {
        return collectionService.getCollectionList(userId, page, limit);
    }

    /**
     * 用户添加收藏
     *
     * @param collectItemPo: CollectItemPo
     * @return collectItemPo
     */
    @PostMapping("/collections")
    public CollectItemPo addCollection(@RequestBody CollectItemPo collectItemPo) {

        return collectionService.addCollection(collectItemPo);
    }

    /**
     * 用户删除收藏
     *
     * @param id：Integer
     * @return null
     */
    @DeleteMapping("/collections/{id}")
    public boolean deleteCollection(@PathVariable Integer id) {
        return collectionService.deleteCollection(id);
    }

}
