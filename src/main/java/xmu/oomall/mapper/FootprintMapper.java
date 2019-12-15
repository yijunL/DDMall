package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.oomall.domain.*;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintMapper
 * @create 2019/12/14 13:30
 */
@Mapper
@Component
public interface FootprintMapper {

    /**
     * 用户获取足迹列表
     *
     * @return List<FootprintItem>
     */
    List<FootprintItem> select();

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return 1 or 0
     */
    int deleteByUserId(Integer id);

    /**
     * 管理员查看足迹
     *
     * @return List<FootprintItem>
     */
    List<FootprintItem> selectAll();
}
