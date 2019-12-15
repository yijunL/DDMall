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
public class CommentServicempl implements CommentService {
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
}
