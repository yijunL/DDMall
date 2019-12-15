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




}