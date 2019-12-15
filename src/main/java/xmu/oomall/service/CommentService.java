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
     *用户获取产品下评论列表
     *
     * @param id
     * @return List<Comment>
     */
    public List<Comment> getCommentsById(Integer id);

}
