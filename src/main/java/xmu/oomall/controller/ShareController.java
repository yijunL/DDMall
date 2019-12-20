package xmu.oomall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareRule;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.domain.Order;
import xmu.oomall.service.ShareService;
import xmu.oomall.util.ResponseUtil;

import javax.validation.constraints.NotNull;

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

    @GetMapping("/goods/{id}/sharerule")
    public Object getShareRuleById(@RequestParam Integer id)
    {

        if(id==null)
            return ResponseUtil.badArgument();

        ShareRulePo sharerule=shareService.getShareRuleById(id);


        if(sharerule==null)
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(sharerule);
    }

    @PostMapping("/sharerule")
    public Object addShareRule(@RequestBody ShareRulePo sharerulePo){

        if(sharerulePo==null||sharerulePo.getShareLevelStrategy()==null||sharerulePo.getGoodsId()==null)
            return ResponseUtil.badArgument();
        ShareRulePo sharerulePo1= (ShareRulePo) shareService.addShareRule(sharerulePo);


        if(sharerulePo1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(sharerulePo1);
    }




    @DeleteMapping("/shareRules/{id}")
    public Object deleteShareRuleById(@PathVariable Integer id) {

        if(id==null)
            return ResponseUtil.badArgument();
        if(shareService.deleteShareRuleById(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }

    /**
     *
     */
    @PutMapping("/sharerule")
    public Object updateShareRule(@RequestBody ShareRulePo sharerulePo,@PathVariable Integer id){

        if(id==null || sharerulePo.getGoodsId()==null||sharerulePo.getShareLevelStrategy()==null)
            return ResponseUtil.badArgument();
        ShareRulePo sharerulePo1= (ShareRulePo) shareService.updateShareRule(sharerulePo,id);
        if(sharerulePo1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(sharerulePo1);

    }


    /**
     *
     */





    @PostMapping("/beSharedItems")
    public Object addBeSharedItems(@RequestBody BeSharedItem beSharedItem) {
        if(beSharedItem==null||beSharedItem.getBeSharedUserId()==null||beSharedItem.getGoodsId()==null||
        beSharedItem.getSharerId()==null)
            return ResponseUtil.badArgument();
        BeSharedItem beSharedItem1= (BeSharedItem) shareService.addBeSharedItems(beSharedItem);
        if(beSharedItem1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(beSharedItem1);
    }

    @GetMapping("/shareitems/{goodsid}")
    public Integer getRebate(Order order) {
        Integer rebate=shareService.getRebate(order);
        if(rebate==null)
            return (Integer) ResponseUtil.badArgument();
        else
            return (Integer) ResponseUtil.ok(rebate);
    }
}