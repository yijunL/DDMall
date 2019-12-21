package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.service.CollectionService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/collectionService")
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
            return ResponseUtil.fail(660,"用户未登录");
        }
        // 参数校验
        if (page == null || page <= 0) {
            return ResponseUtil.fail(763,"收藏不存在");
        }
        if (limit == null || limit <= 0) {
            return ResponseUtil.fail(763,"收藏不存在");
        }
        List<CollectItem> collectItemList=collectionService.getCollectionList(userId, page, limit);
        if(collectItemList==null)
        {
            return ResponseUtil.fail(763,"收藏不存在");
        }
        return ResponseUtil.ok(collectItemList);
    }

    /**
     * 用户添加收藏
     *
     * @param collectItemPo: CollectItemPo
     * @return collectItemPo
     */
    @PostMapping("/collections")
    public Object addCollection(HttpServletRequest request, @RequestBody CollectItemPo collectItemPo) {

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        //参数校验
        if(collectItemPo.getId()!=null) {
            return ResponseUtil.fail(761,"用户没有权利插入收藏Id");
        }
        if(collectItemPo.getGoodsId()==null) {
            return ResponseUtil.fail(761,"收藏商品Id不能为空");
        }
        if(collectItemPo.getUserId()==null) {
            return ResponseUtil.fail(761,"用户Id不能为空");
        }
        collectItemPo = collectionService.addCollection(collectItemPo);
        if(collectItemPo==null)
            return ResponseUtil.fail(761,"收藏新增失败");
        else
            return ResponseUtil.ok(collectItemPo);
    }

    /**
     * 用户删除收藏
     *
     * @param id：Integer
     * @return null
     */
    @DeleteMapping("/collections/{id}")
    public Object deleteCollection (HttpServletRequest request, @PathVariable Integer id) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }

        // 参数校验
        if (id == null || id < 0) {
            return ResponseUtil.fail(762,"所删除的收藏不存在");
        }
        if(collectionService.deleteCollection(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.fail(762,"收藏删除失败");
    }

}
