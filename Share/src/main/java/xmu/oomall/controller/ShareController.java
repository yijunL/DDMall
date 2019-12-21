package xmu.oomall.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.domain.Order;
import xmu.oomall.service.ShareService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xyt
 * @create 2019/12/4 13:00
 */

@RestController
@RequestMapping("/shareService")
public class ShareController {
    /**
     *
     */
    @Autowired
    private ShareService shareService;

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

    @GetMapping("/goods/{id}/shareRules")
    public Object getShareRuleById(HttpServletRequest request, @PathVariable Integer id)
    {

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(id==null)
            return ResponseUtil.fail(612,"分享规则查看失败");


        ShareRulePo sharerule=shareService.getShareRuleById(id);


        if(sharerule==null)
            return ResponseUtil.fail(612,"分享规则查看失败");
        else
            return ResponseUtil.ok(sharerule);
    }

    @PostMapping("/shareRules")
    public Object addShareRule(HttpServletRequest request, @PathVariable ShareRulePo sharerulePo){

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(sharerulePo==null||sharerulePo.getShareLevelStrategy()==null||sharerulePo.getGoodsId()==null)
            return ResponseUtil.fail(610,"分享规则创建失败");
        ShareRulePo sharerulePo1= (ShareRulePo) shareService.addShareRule(sharerulePo);


        if(sharerulePo1==null)
            return ResponseUtil.fail(610,"分享规则创建失败");
        else
            return ResponseUtil.ok(sharerulePo1);
    }




    @DeleteMapping("/shareRules/{id}")
    public Object deleteShareRuleById(HttpServletRequest request, @PathVariable Integer id) {

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(id==null)
            return ResponseUtil.fail(611,"分享规则删除失败");
        if(shareService.deleteShareRuleById(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.fail(611,"分享规则删除失败");

    }

    /**
     *
     */
    @PutMapping("/shareRules/{id}")
    public Object updateShareRule(HttpServletRequest request, @RequestBody ShareRulePo sharerulePo,@PathVariable Integer id){

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(id==null || sharerulePo.getGoodsId()==null||sharerulePo.getShareLevelStrategy()==null)
            return ResponseUtil.fail(613,"分享规则修改失败");
        ShareRulePo sharerulePo1= (ShareRulePo) shareService.updateShareRule(sharerulePo,id);
        if(sharerulePo1==null)
            return ResponseUtil.fail(613,"分享规则修改失败");
        else
            return ResponseUtil.ok(sharerulePo1);

    }


    /**
     *
     */





    @PostMapping("/beSharedItems")
    public Object addBeSharedItems(HttpServletRequest request, @RequestBody BeSharedItem beSharedItem) {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(beSharedItem==null||beSharedItem.getBeSharedUserId()==null||beSharedItem.getGoodsId()==null||
        beSharedItem.getSharerId()==null)
            return ResponseUtil.fail(614,"增加分享项失败");
        BeSharedItem beSharedItem1= (BeSharedItem) shareService.addBeSharedItems(beSharedItem);
        if(beSharedItem1==null)
            return ResponseUtil.fail(614,"增加分享项失败");
        else
            return ResponseUtil.ok(beSharedItem1);
    }

    @GetMapping("/rebate")
    public Integer getRebate(HttpServletRequest request, @RequestBody Order order) {


        Integer rebate=shareService.getRebate(order);
        if(rebate==null)
            return (Integer) ResponseUtil.badArgument();
        else
            return (Integer) ResponseUtil.ok(rebate);
    }
}