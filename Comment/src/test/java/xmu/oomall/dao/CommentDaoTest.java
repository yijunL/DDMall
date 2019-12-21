package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Comment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentDaoTest {

    @Autowired CommentDao commentDao;

    @Test
    void selectByProductId() {
      /*  commentDao.selectByProductId(20,1,222).
                forEach(comment -> System.out.println(comment.getId()));
*/
       /* commentDao.selectByIdForAdmin(null,null,1,5).
                forEach(comment -> System.out.println(comment.getId()));*/

        /*commentDao.selectAllComments(1,20).forEach(comment -> System.out.println(comment.getId()));*/

      /* commentDao.selectByIdForAdmin(null,333,1,20).
                forEach(comment -> System.out.println(comment.getId()));*/

     /* System.out.println(commentDao.selectComment(2).getId());*/
    }

    @Test
    void addComment() {



    }

    @Test
    void deleteComment() {
        //commentDao.deleteComment(3);
    }

    @Test
    void selectComment() {
    }

    @Test
    void updateComment() {
    }
}
