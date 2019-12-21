package xmu.oomall.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentMapperTest {

    @Autowired OomallCommentMapper commentMapper;

    @Test
    void selectComment() {
        //commentMapper.findAllByProductId(222).forEach(commentPo -> System.out.println(commentPo.getId()));
    }
}
