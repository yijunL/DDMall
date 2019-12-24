package xmu.oomall.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.CommentPo;

import java.time.LocalDateTime;

@SpringBootTest
public class CommentMapperTest {

    @Autowired OomallCommentMapper commentMapper;

    @Test
    void selectComment() {
        //commentMapper.findAllByProductId(222).forEach(commentPo -> System.out.println(commentPo.getId()));

        //System.out.println(commentMapper.deleteById(LocalDateTime.now(),1));

 /*       CommentPo commentPo= new CommentPo();
        commentPo.setContent("今天");
        commentPo.setId(11);
        commentPo.setProductId(222);
        commentPo.setStar(4);
        commentPo.setStatusCode(3);
        commentPo.setUserId(333);
        commentPo.setBeDeleted(null);
        commentPo.setGmtModified(LocalDateTime.now());*/

        //System.out.println(commentMapper.updateById(commentPo,1));

        //commentMapper.insertSelective(commentPo);

        //commentMapper.findAllByProductId(123);
    }
}
