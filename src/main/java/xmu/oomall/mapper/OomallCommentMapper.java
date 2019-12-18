package xmu.oomall.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.CommentPo;

import java.util.List;

@Mapper
public interface OomallCommentMapper {
    /**
     * 用户获取产品下评论列表
     *
     * @param productId
     * @return
     */
    List<CommentPo> findAllByProductId(@Param("productId") Integer productId);

    /**
     * 用户在产品下发表评论
     *
     * @param commentPo
     * @return
     */
    int insertSelective(CommentPo commentPo);

    /**
     * 管理员删除评论
     *
     * @param id
     * @return 0:失败 1：成功
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 管理员审核单条评论
     *
     * @param updated
     * @param id
     * @return
     */
    int updateById(@Param("updated") CommentPo updated, @Param("id") Integer id);

    /**
     * 根据id查找评论
     *
     * @param id
     * @return CommentPo
     */
    CommentPo selectAllById(@Param("id") Integer id);

    /**
     * 获取所有评论
     *
     * @return List<CommentPo>
     */
    List<CommentPo> selectALL();

    /**
     * 根据条件获取评论
     *
     * @param userId
     * @param productId
     * @return List<CommentPo>
     */
    List<CommentPo> selectAllByUserIdOrProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);


}