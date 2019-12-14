package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;

import java.util.List;

/**
 * @author KingKong
 * @Description: CommentService
 * @create 2019/12/14 21:53
 */

@Service
public interface CommentService {

    /**
     *
     * @param id
     * @return List<Comment>
     */
    public List<CommentPo> getCommentsById(Integer id);

}
