package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.mapper.OomallCommentMapper;
import xmu.oomall.util.Copyer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KingKong
 * @Description: CommentDao
 * @create 2019/12/13 23:08
 */

@Repository
public class CommentDao {
    @Autowired
    private OomallCommentMapper commentMapper;

    /**
     * 用户获取产品下评论列表
     *
     * @param id
     * @return
     */
    public List<Comment> selectByProductId(Integer id){
        List<CommentPo> commentsOfProduct = commentMapper.findAllByProductId(id);
        return commentsList(commentsOfProduct);
    }

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return 0：失败 1：成功
     */
    public int addComment(CommentPo commentPo){
        if(commentMapper.insertSelective(commentPo)>0)
            return 1;
        else return 0;
    }

    /**
     * 管理员删除评论
     *
     * @param id
     * @return true:删除成功  false:删除失败
     */
    public boolean deleteComment(Integer id){
        return commentMapper.deleteById(id)==1;
    }


    public Comment selectComment(Integer id){
        CommentPo commentPo=commentMapper.selectAllById(id);
        return comments(commentPo);
    }

    public Comment updateComment(CommentPo commentPo,Integer id){
        return null;
    }


    /**
     * 将commentPo列表转换成comment列表
     *
     * @return commentsList
     */
    private List<Comment> commentsList(List<CommentPo> commentPos){
        List<Comment> comments=new ArrayList<Comment>();
        for(CommentPo commentPo:commentPos){
            comments.add(comments(commentPo));
        }
        return comments;
    }

    /**
     *将commentPo转换成comment
     *
     * @return comments
     */
    private Comment comments(CommentPo commentPo){
        Comment comment = new Comment();
        return Copyer.Copy(commentPo,comment)?comment:null;
    }






}
