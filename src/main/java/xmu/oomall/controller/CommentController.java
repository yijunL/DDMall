package xmu.oomall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.domain.ProductPo;
import xmu.oomall.domain.User;
import xmu.oomall.service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KingKong
 * @Description CommentController
 * @create 2019/12/14 21:35
 */


@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 用户获取产品下评论列表
     *
     * @param id
     * @return List<Comment>
     */
    @GetMapping("/product/{id}/comments")
    public Object getCommentsById(@RequestParam Integer id)
    {
        List<Comment> commentPoList=commentService.getCommentsById(id);
       /* User user=userService.getUserById(commentPoList.get(0).getUserId());
        ProductPo productPo=productService.getProductPoById(id);
        List<Comment> commentList = new ArrayList<Comment>();
        Comment comment;
        for(int i=0;i<commentPoList.size();i++){
            comment= new Comment(user,productPo,commentPoList.get(i));*/
       return commentPoList;

    }

}
