package xmu.oomall.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;

import java.util.List;

@SpringBootTest
public class CommentControllerTest {
    @Autowired
    private CommentController commentController;

    @Test
    public void commentControllerTest(){

        commentController.getCommentsById(222,1,20);

        //commentController.getCommentsById(1);
        //44,55,"yukeyishishabi",0,4,77,null,null,0
        CommentPo commentPo= new CommentPo();
        commentPo.setBeDeleted(false);
        commentPo.setContent("yukeyishishabi");
        commentPo.setId(11);
        commentPo.setProductId(222);
        commentPo.setStar(4);
        commentPo.setStatusCode(0);
        commentPo.setUserId(333);

       // commentController.addComment(1,commentPo);

        // System.out.println(commentController.deleteComment(112));
    }
}