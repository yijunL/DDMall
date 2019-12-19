package xmu.oomall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.service.CommentService;
import xmu.oomall.util.ResponseUtil;

import java.util.List;

/**
 * @author KingKong
 * @Description CommentController
 * @create 2019/12/14 21:35
 */


@RestController
@RequestMapping("commentsService")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 用户获取产品下评论列表
     *
     * @param id
     * @param page
     * @param limit
     * @return List<Comment>
     */
    //记得判断productid是否合法(Userid可能也要)
    @GetMapping("/product/{id}/comments")
    public Object getCommentsById(@RequestParam Integer id,
                                  @RequestParam Integer page,
                                  @RequestParam Integer limit)
    {
        if(id==null||page==null||limit==null||page<0||limit<0){
            return ResponseUtil.fail(902,"获取评论失败");
        } else{
            List<Comment> commentList=commentService.getCommentsById(limit,page,id);
                //后续可以调用其他模块的时候要封装成List<Commnet>
                return ResponseUtil.ok(commentList);
        }
       /* User user=userService.getUserById(commentPoList.get(0).getUserId());
        ProductPo productPo=productService.getProductPoById(id);
        List<Comment> commentList = new ArrayList<Comment>();
        Comment comment;
        for(int i=0;i<commentPoList.size();i++){
            comment= new Comment(user,productPo,commentPoList.get(i));*/
    }

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return 0:失败 1：成功
     */
    @PostMapping("/product/{id}/comments")//id是否需要？
    public Object addComment(@RequestParam Integer id,@RequestBody CommentPo commentPo){
        if(commentPo==null){
            return ResponseUtil.fail(903,"创建评论失败");
        } else{
            if(commentService.addComment(commentPo)==null){
                return ResponseUtil.fail(903,"创建评论失败");
            } else{
                return ResponseUtil.ok(commentPo);
            }
        }
    }

    /**
     * 管理员删除评论
     *
     * @param id
     * @return ResponseUtil.ok()
     */
    @DeleteMapping("/comments/{id}")
    public Object deleteComment(@RequestParam Integer id){
        if(id==null){
            return ResponseUtil.fail(905,"删除评论失败");
        } else{
            if(commentService.deleteComment(id)==0){
                return ResponseUtil.fail(905,"删除评论失败");
            } else{
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
    public Object getCommentByIdForAdmin(@RequestParam Integer userId,
                                         @RequestParam Integer productId,
                                         @RequestParam Integer limit,
                                         @RequestParam Integer page){
        if(limit==null||page==null||limit<0||page<0){
            return ResponseUtil.fail(902,"获取评论失败");
        } else{
            List<Comment> commentList;
            if(userId==null&&productId==null){
                 commentList=commentService.getAllComments(limit,page);
            } else{
                commentList =commentService.getCommentsByIdForAdmin(userId,productId,limit,page);
            }
                //记得封装成List<Comment>
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
    public Object updateCommentById(@RequestParam Integer id,@RequestBody CommentPo commentPo){
        if(id==null||commentPo.getStatusCode()!=0||commentPo.getBeDeleted()){
            return ResponseUtil.fail(904,"修改评论失败");
        } else{
            CommentPo commentPo1=commentService.updateCommentById(id, commentPo);
            if(commentPo1==null){
                return ResponseUtil.fail(904,"修改评论失败");
            } else{
                return ResponseUtil.ok(commentPo1);
            }
        }
    }
}
