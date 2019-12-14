package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.mapper.CommentMapper;

import java.util.List;

/**
 * @author KingKong
 * @Description: CommentDao
 * @create 2019/12/13 23:08
 */

@Repository
public class CommentDao {
    @Autowired
    private CommentMapper commentMapper;

    public List<CommentPo> selectByProductId(Integer id){
        List<CommentPo> commentsOfProduct = commentMapper.selectByProductId(id);
        return commentsOfProduct;
    }




}
