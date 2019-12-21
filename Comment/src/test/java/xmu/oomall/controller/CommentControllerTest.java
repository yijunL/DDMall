package xmu.oomall.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;

import java.net.UnknownHostException;
import java.util.List;

@SpringBootTest
public class CommentControllerTest {
    @Autowired
    private CommentController commentController;

    @Test
    public void commentControllerTest() throws UnknownHostException {

        //commentController.getCommentsById(null,222,1,20);

        //commentController.getCommentsById(1);
        //44,55,"yukeyishishabi",0,4,77,null,null,0
        CommentPo commentPo= new CommentPo();
        commentPo.setBeDeleted(false);
        commentPo.setContent("yukeyishishabi111");
        commentPo.setId(11);
        commentPo.setProductId(222);
        commentPo.setStar(4);
        commentPo.setStatusCode(5);
        commentPo.setUserId(333);
        commentPo.setBeDeleted(null);

        //commentController.addComment(1,commentPo);

       // commentController.deleteComment(4);


        //commentController.getCommentByIdForAdmin(null,222,1,20);

        // System.out.println(commentController.deleteComment(112));

        //commentController.updateCommentById(null,9,commentPo);
    }
}