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
     * 用户获取产品下评论列表
     *
     * @param id
     * @return List<Comment>
     */
    public List<Comment> getCommentsById(Integer limit, Integer page, Integer id);

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return 0：失败  1：成功
     */
    public CommentPo addComment(CommentPo commentPo);

    /**
     * 管理员删除评论
     *
     * @param id
     * @return 0：失败 1：成功
     */
    public int deleteComment(Integer id);

    /**
     * 管理员获取所有评论
     *
     * @param limit
     * @param page
     * @return List<Comment>
     */
    public List<Comment> getAllComments(Integer limit, Integer page);

    /**
     * 管理员根据条件获取评论
     *
     * @param UserId
     * @param ProductId
     * @param limit
     * @param page
     * @return List<Comment>
     */
    public List<Comment> getCommentsByIdForAdmin(Integer UserId, Integer ProductId,
                                                 Integer limit, Integer page);

    /**
     * 管理员审核单条评论
     *
     * @param id
     * @param commentPo
     * @return CommentPo
     */
    public CommentPo updateCommentById(Integer id, CommentPo commentPo);


}
