package xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Comment;
import xmu.oomall.domain.CommentPo;
import xmu.oomall.mapper.OomallCommentMapper;
import xmu.oomall.util.Copyer;

import java.time.LocalDateTime;
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
     * @param limit
     * @param page
     * @param id
     * @return
     */
    public List<Comment> selectByProductId(Integer limit,Integer page,Integer id){
        PageHelper.startPage(page,limit);
        List<CommentPo> commentsOfProduct = commentMapper.findAllByProductId(id);
        return commentsList(commentsOfProduct);
    }




    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return 0：失败 1：成功
     */
    public CommentPo addComment(CommentPo commentPo){
        if(isArgsInvalid(commentPo)){
            return null;
        }else{
            commentPo.setGmtCreate(LocalDateTime.now());
            commentPo.setGmtModified(LocalDateTime.now());
            commentPo.setBeDeleted(false);
            if(commentMapper.insertSelective(commentPo)==0){
                return null;
            } else{
                return commentPo;
            }
        }
    }

    /**
     * 管理员删除评论
     *
     * @param id
     * @return true:删除成功  false:删除失败
     */
    public boolean deleteComment(Integer id){
        return commentMapper.deleteById(LocalDateTime.now(),id)==1;
    }

    /**
     * 根据Id获取评论
     *
     * @param id
     * @return comment
     */
    public Comment selectComment(Integer id){
        CommentPo commentPo=commentMapper.selectAllById(id);
        return comments(commentPo);
    }

    /**
     * 管理员根据条件查看评论
     *
     * @param userId
     * @param productId
     * @param limit
     * @param page
     * @return List<Comment>
     */
    public List<Comment> selectByIdForAdmin(Integer userId,Integer productId,Integer limit,Integer page){
        PageHelper.startPage(page,limit);
        List<CommentPo> commentPoList=commentMapper.selectAllByUserIdOrProductId(userId,productId);
        return commentsList(commentPoList);
    }

    /**
     * 获取所有评论
     *
     * @param limit
     * @param page
     * @return List<Comment>
     */
    public List<Comment> selectAllComments(Integer limit,Integer page){
        PageHelper.startPage(page,limit);
        List<CommentPo> commentPoList=commentMapper.selectAll();
        return commentsList(commentPoList);
    }


    /**
     * 管理员审核单条评论
     *
     * @param id
     * @param commentPo
     * @return CommentPo
     */
    public CommentPo updateComment(Integer id,CommentPo commentPo){
        if(isArgsInvalid(commentPo)){
            return null;
        } else{
            commentPo.setGmtModified(LocalDateTime.now());
            if(commentMapper.updateById(commentPo,id)==1){
                return commentMapper.selectAllById(id);
            } else{
                return null;
            }
        }
    }


    private boolean isArgsInvalid(CommentPo commentPo)
    {
        Integer one=new Integer(1);
        Integer five=new Integer(5);
        Integer zero=new Integer(0);
        Integer two=new Integer(2);
        if(commentPo.getStar()<one||commentPo.getStar()>five){
            return true;
        }
        if(commentPo.getStatusCode()<zero||commentPo.getStatusCode()>two){
            return true;
        }
        return false;
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
        return Copyer.copy(commentPo,comment)?comment:null;
    }






}
