package xmu.oomall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.service.CommentService;

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
    public List<CommentPo> getCommentsById(@RequestParam Integer id)
    {
        return commentService.getCommentsById(id);
    }

}
