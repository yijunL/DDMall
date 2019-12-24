package xmu.oomall.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.AddLog;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.Log;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.domain.Order;
import xmu.oomall.service.ShareService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

/**
 * @Author
 * @create 2019/12/4 13:00
 */

@RestController
@RequestMapping(value="")
public class ShareController {
    /**
     *
     */
    @Autowired
    private ShareService shareService;

    @Autowired
    private AddLog addLog;

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
     * 通过id获取分享规则
     * @param request
     * @param id
     * @return ShareRulePo
     */
    @GetMapping("/goods/{id}/shareRules")
    public Object getShareRuleById(HttpServletRequest request, @PathVariable Integer id) throws UnknownHostException {

        Integer userId = getUserId(request);
    //    if (userId == null) {
    //        return ResponseUtil.fail(669,"管理员未登录");
     //   }
     /*   Log log = new Log();
        log.setAdminId(userId);
        log.setActionId(id);
        log.setActions("查询分享规则");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(0); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());*/
        if(id==null)
        {
      //      log.setStatusCode(0);
       //     addLog.addLog(log);
            return ResponseUtil.fail(612,"分享规则查看失败，参数缺少");}
        ShareRulePo sharerule=shareService.getShareRuleById(id);
        if(sharerule==null)
            return ResponseUtil.fail(612,"分享规则查看失败,参数错误");
        else {
         //   log.setStatusCode(1);
          //  addLog.addLog(log);
            return ResponseUtil.ok(sharerule);
        }
    }

    /**
     * 增加分享规则
     * @param request
     * @param sharerulePo
     * @return ShareRulePo
     */
    @PostMapping("/shareRules")
    public Object addShareRule(HttpServletRequest request, @PathVariable ShareRulePo sharerulePo) throws Exception {

        Integer userId = getUserId(request);

        if (userId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }

        Log log = new Log();
        log.setAdminId(userId);
        log.setActions("增添分享规则");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(1); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());

        if(sharerulePo==null||sharerulePo.getShareLevelStrategy()==null||sharerulePo.getGoodsId()==null)
        {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(610,"分享规则创建失败，参数缺少");
        }
        ShareRulePo sharerulePo1= (ShareRulePo) shareService.addShareRule(sharerulePo);


        if(sharerulePo1==null) {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(610, "分享规则创建失败，参数错误");
        }
        else {
            log.setStatusCode(1);
            addLog.addLog(log);
            return ResponseUtil.ok(sharerulePo1);
        }
    }


    /**
     * 通过分享规则id删除分享规则
     * @param request
     * @param id
     * @return
     */
    @DeleteMapping("/shareRules/{id}")
    public Object deleteShareRuleById(HttpServletRequest request, @PathVariable Integer id) throws UnknownHostException {

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }
        Log log = new Log();
        log.setAdminId(userId);
        log.setActionId(id);
        log.setActions("删除分享规则");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(3); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());
        if(id==null)
        {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(611,"分享规则删除失败，参数缺少");}
        if(shareService.deleteShareRuleById(id))
        {
            log.setStatusCode(1);
            addLog.addLog(log);
            return ResponseUtil.ok();}
        else{
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(611,"分享规则删除失败，参数错误");}

    }

    /**
     * 更新分享规则
     * @param request
     * @param sharerulePo
     * @param id
     * @return
     */
    @PutMapping("/shareRules/{id}")
    public Object updateShareRule(HttpServletRequest request, @RequestBody ShareRulePo sharerulePo,@PathVariable Integer id) throws Exception {

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }
        Log log = new Log();
        log.setAdminId(userId);
        log.setActionId(id);
        log.setActions("修改分享规则");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(2); //操作类型
        log.setIp(InetAddress.getLocalHost().toString());
        if(id==null || sharerulePo.getGoodsId()==null||sharerulePo.getShareLevelStrategy()==null)
        {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(613,"分享规则修改失败，参数缺少");
        }
        ShareRulePo sharerulePo1= (ShareRulePo) shareService.updateShareRule(sharerulePo,id);
        if(sharerulePo1==null)
        {
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(613,"分享规则修改失败，参数错误");}
        else
        {
            log.setStatusCode(1);
            addLog.addLog(log);
            return ResponseUtil.ok(sharerulePo1);
        }
    }


    /**
     * 增加被分享记录表
     * @param request
     * @param beSharedItem
     * @return
     */

    @PostMapping("/beSharedItems")
    public Object addBeSharedItems(HttpServletRequest request, @RequestBody BeSharedItem beSharedItem)  {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }


        if(beSharedItem==null||beSharedItem.getBeSharedUserId()==null||beSharedItem.getGoodsId()==null||
        beSharedItem.getSharerId()==null)
        {

            return ResponseUtil.fail(614,"增加分享项失败,参数缺少");
        }
        BeSharedItem beSharedItem1= (BeSharedItem) shareService.addBeSharedItems(beSharedItem);
        if(beSharedItem1==null)
        {

            return ResponseUtil.fail(614,"增加分享项失败，参数错误");
        }
        else
        {

            return ResponseUtil.ok(beSharedItem1);
        }
    }

    /**
     * 根据订单获取返点
     * @param request
     * @param order
     * @return Integer
     */
    @GetMapping("/rebate")
    public Object getRebate(HttpServletRequest request, @RequestBody Order order) {

        Integer rebate=shareService.getRebate(order);
        return  ResponseUtil.ok(rebate);
    }
}