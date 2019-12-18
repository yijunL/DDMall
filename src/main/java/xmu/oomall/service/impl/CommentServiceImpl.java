package xmu.oomall.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.CommentDao;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.service.CommentService;

import java.util.List;

/**
 * @author KingKong
 * @Description: CommentServicempl
 * @create 2019/12/14 23:00
 */


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;


    /**
     * 用户获取产品下评论列表
     *
     * @param limit
     * @param page
     * @param id
     * @return
     */
    @Override
    public List<Comment> getCommentsById(Integer limit, Integer page, Integer id) {
        List<Comment> commentsOfProduct = commentDao.selectByProductId(limit, page, id);
        return commentsOfProduct;
    }

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return 0：失败 1：成功
     */
    @Override
    public CommentPo addComment(CommentPo commentPo) {
        return commentDao.addComment(commentPo);
    }

    /**
     * 管理员删除评论
     *
     * @param id
     * @return 0：失败 1：成功
     */
    @Override
    public int deleteComment(Integer id) {
        Comment comment = commentDao.selectComment(id);
        //数据库有此comment并且还未被删除
        if (comment != null && !comment.getBeDeleted()) {
            if (commentDao.deleteComment(id)) {
                return 1;
            }
        }
        return 0;
    }


    /**
     * 管理员根据条件获取评论
     *
     * @param userId
     * @param productId
     * @param limit
     * @param page
     * @return List<Comment>
     */
    @Override
    public List<Comment> getCommentsByIdForAdmin(Integer userId, Integer productId, Integer limit, Integer page) {
        List<Comment> commentList = commentDao.selectByIdForAdmin(userId, productId, limit, page);
        return commentList;
    }

    /**
     * 管理员获取所有评论
     *
     * @param limit
     * @param page
     * @return List<Comment>
     */
    @Override
    public List<Comment> getAllComments(Integer limit, Integer page) {
        List<Comment> commentList = commentDao.selectAllComments(limit, page);
        return commentList;
    }


    /**
     * 管理员审核单条评论
     *
     * @param id
     * @param commentPo
     * @return CommentPo
     */
    @Override
    public CommentPo updateCommentById(Integer id, CommentPo commentPo) {
        return commentDao.updateComment(id, commentPo);
    }
}
