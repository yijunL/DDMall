package xmu.oomall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.AddLog;
import xmu.oomall.domain.*;
import xmu.oomall.service.CommentService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author KingKong
 * @Description CommentController
 * @create 2019/12/14 21:35
 */


@RestController
@RequestMapping("commentService")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private AddLog addLog;

    /**
     * 解析http请求获取该请求者的id
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
     * 用户获取产品下评论列表
     *
     * @param id
     * @param page
     * @param limit
     * @return List<Comment>
     */
 //   GetMapping("/product")
    @GetMapping("/product/{id}/comments")
    public Object getCommentsById(HttpServletRequest request,
                                  @RequestParam Integer id,
                                  @RequestParam Integer page,
                                  @RequestParam Integer limit)
    {
        Integer userId=getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(id==null||page==null||limit==null||page<=0||limit<=0){
            return ResponseUtil.fail(902,"获取评论失败");
        } else{
            List<Comment> commentList=commentService.getCommentsById(limit,page,id);
            commentList.forEach(comment -> System.out.println(comment.getId()));
            User user= new User();
            ProductPo productPo = new ProductPo();
            if(!commentList.isEmpty()){
                user.setId(commentList.get(0).getUserId());
                user.setId(commentList.get(0).getProductId());
            }
            commentList.forEach(comment -> {comment.setProductPo(productPo);
                comment.setUser(user);});
                return ResponseUtil.ok(commentList);
        }
    }

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return ResponseUtil.ok()
     */
    @PostMapping("/product/{id}/comments")
    public Object addComment(HttpServletRequest request,@RequestParam Integer id,@RequestBody CommentPo commentPo){
        Integer userId=getUserId(request);
        if (userId == null) {
            return ResponseUtil.fail(660,"用户未登录");
        }
        if(id==null||commentPo==null||commentPo.getContent()==null||commentPo.getStar()==null){
            return ResponseUtil.fail(903,"创建评论失败");
        }
        if(commentPo.getBeDeleted()!=null&&commentPo.getBeDeleted()==true){
            return ResponseUtil.fail(903,"创建评论失败");
        }
        if(commentPo.getStatusCode()!=null&&commentPo.getStatusCode()!=0) {
            return ResponseUtil.fail(903,"创建评论失败");
        }
        commentPo.setStatusCode(0);
        commentPo.setProductId(id);
        if(commentService.addComment(commentPo)==null){
            return ResponseUtil.fail(903,"创建评论失败");
        } else{
            return ResponseUtil.ok(commentPo);
        }
    }

    /**
     * 管理员删除评论
     *
     * @param id
     * @return ResponseUtil.ok()
     */
    @DeleteMapping("/comments/{id}")
    public Object deleteComment(HttpServletRequest request,@RequestParam Integer id) throws UnknownHostException {
        Integer adminId=getUserId(request);
        if (adminId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }

        Log log=new Log();
        log.setAdminId(adminId);
        log.setActionId(id);
        log.setActions("查看评论");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(3);
        log.setIp(InetAddress.getLocalHost().toString());

        if(id==null){
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(905,"删除评论失败");
        } else{
            if(commentService.deleteComment(id)==0){
                log.setStatusCode(0);
                addLog.addLog(log);
                return ResponseUtil.fail(905,"删除评论失败");
            } else{
                log.setStatusCode(1);
                addLog.addLog(log);
                return ResponseUtil.ok();
            }
        }
    }

    /**
     * 管理员根据条件获取评论(或者获取所有评论)
     *
     * @param userId
     * @param productId
     * @param limit
     * @param page
     * @return List<Comment>
     */
    @GetMapping("/admin/comments")
    public Object getCommentByIdForAdmin(HttpServletRequest request,
                                         @RequestParam Integer userId,
                                         @RequestParam Integer productId,
                                         @RequestParam Integer page,
                                         @RequestParam Integer limit) throws UnknownHostException {

         Integer adminId=getUserId(request);
        if (adminId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }
        if (limit == null || page == null || limit <= 0 || page <= 0) {
            return ResponseUtil.fail(902, "获取评论失败");
        } else {
            Log log=new Log();
            log.setAdminId(adminId);
            log.setActionId(userId);
            log.setActions("查看评论");
            log.setGmtCreate(LocalDateTime.now());
            log.setGmtModified(LocalDateTime.now());
            log.setType(0);
            log.setIp(InetAddress.getLocalHost().toString());
            List<Comment> commentList;
            if (userId == null && productId == null) {
                commentList = commentService.getAllComments(limit, page);
            } else {
                commentList = commentService.getCommentsByIdForAdmin(userId, productId, limit, page);
            }
            log.setStatusCode(1);
            addLog.addLog(log);
            User user= new User();
            ProductPo productPo=new ProductPo();
            if(!commentList.isEmpty()){
                productPo.setId(commentList.get(0).getProductId());
                user.setId(commentList.get(0).getUserId());
            }
            commentList.forEach(comment -> {comment.setProductPo(productPo);
                                            comment.setUser(user);});
            return ResponseUtil.ok(commentList);
        }
    }

    /**
     * 管理员审核单条评论
     *
     * @param id
     * @param commentPo
     * @return CommentPo
     */
    @PutMapping("/admin/comments/{id}")
    public Object updateCommentById(HttpServletRequest request, @RequestParam Integer id,
                                    @RequestBody CommentPo commentPo) throws UnknownHostException {
        Integer adminId=getUserId(request);
        if (adminId == null) {
            return ResponseUtil.fail(669,"管理员未登录");
        }
        Log log=new Log();
        log.setAdminId(adminId);
        log.setActionId(id);
        log.setActions("审核评论");
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        log.setType(2);
        log.setIp(InetAddress.getLocalHost().toString());

        if(id==null||commentPo.getStatusCode()==null||commentPo.getStatusCode()==0){
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(904,"修改评论失败");
        }
        if(commentPo.getBeDeleted()!=null&&commentPo.getBeDeleted()==true){
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(904,"修改评论失败");
        }
        CommentPo commentPo1=commentService.updateCommentById(id, commentPo);
        if(commentPo1==null){
            log.setStatusCode(0);
            addLog.addLog(log);
            return ResponseUtil.fail(904,"修改评论失败");
        } else{
            log.setStatusCode(1);
            addLog.addLog(log);
            return ResponseUtil.ok(commentPo1);
        }
    }
}
