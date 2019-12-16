package xmu.oomall.mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.CommentPo;

import java.util.List;

@Mapper
public interface CommentMapper {


    /**
     * 用户获取产品下评论列表
     *
     * @param productId
     * @return
     */
    List<CommentPo> findAllByProductId(@Param("productId")Integer productId);

    /**
     *用户在产品下发表评论
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
    int deleteById(@Param("id")Integer id);










}