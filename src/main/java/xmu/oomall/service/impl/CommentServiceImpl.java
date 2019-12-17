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
     * @param id
     * @return
     */
    @Override
    public List<Comment> getCommentsById(Integer id) {
        List<Comment> commentsOfProduct = commentDao.selectByProductId(id);
        return commentsOfProduct;
    }

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return 0：失败 1：成功
     */
    @Override
    public int addComment(CommentPo commentPo){
        return commentDao.addComment(commentPo);
    }

    /**
     * 管理员删除评论
     *
     * @param id
     * @return 0：失败 1：成功
     */
    @Override
    public int deleteComment(Integer id){
        Comment comment=commentDao.selectComment(id);
        if(comment!=null){
            if(commentDao.deleteComment(id)){
                return 1;
            }
        }
        return 0;
    }
}
