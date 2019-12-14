package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.CommentPo;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentPo> selectByProductId(Integer id);

}