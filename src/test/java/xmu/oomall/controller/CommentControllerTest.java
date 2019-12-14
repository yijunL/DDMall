package xmu.oomall.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentControllerTest {
    @Autowired
    private CommentController commentController;

    @Test
    public void commentControllerTest(){commentController.getCommentsById(1);}
}
