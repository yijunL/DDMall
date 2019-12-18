package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.service.CollectionService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("collectionService")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 解析请求
     * @param request
     * @return
     */
    private Integer getUserId(HttpServletRequest request) {
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null) {
            return null;
        }
        return Integer.valueOf(userIdStr);
    }

    /**
     * 用户查看收藏列表
     *
     * @param request: HttpServletRequest
     * @param page：Integer
     * @param limit：Integer
     * @return List<CollectItem>
     */
    @GetMapping("/collections")
    public Object getCollectionList(HttpServletRequest request, @RequestParam Integer page,
                                                 @RequestParam Integer limit) {
        Integer userId=getUserId(request);
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        // 参数校验
        if (page == null || page < 0) {
            return ResponseUtil.badArgumentValue();
        }
        if (limit == null || limit < 0) {
            return ResponseUtil.badArgumentValue();
        }
        List<CollectItem> collectItemList=collectionService.getCollectionList(userId, page, limit);
        return ResponseUtil.ok(collectItemList);
    }

    /**
     * 用户添加收藏
     *
     * @param collectItemPo: CollectItemPo
     * @return collectItemPo
     */
    @PostMapping("/collections")
    public Object addCollection(@RequestBody CollectItemPo collectItemPo) {

        if(collectItemPo==null)
            return ResponseUtil.badArgument();
        CollectItemPo collectItemPo1 = collectionService.addCollection(collectItemPo);
        if(collectItemPo1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(collectItemPo1);
    }

    /**
     * 用户删除收藏
     *
     * @param id：Integer
     * @return null
     */
    @DeleteMapping("/collections/{id}")
    public Object deleteCollection (@PathVariable Integer id) {
        if(id==null)
            return ResponseUtil.badArgument();
        if(collectionService.deleteCollection(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }

}
