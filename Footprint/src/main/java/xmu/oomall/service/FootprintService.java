package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

/**
 * @Author Bexasusual
 * @Description: FootprintService
 * @create 2019/12/14 13:30
 */

@Service
public interface FootprintService {

    /**
     * 用户获取足迹列表
     *
     * @param userId: Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> listFootprintsByUserId(Integer userId, Integer page, Integer limit);

    /**
     * 用户删除足迹（弃用）
     *
     * @param id：Integer
     * @return Response.ok()
     */
    public int deleteFootprintById(Integer id);

    /**
     * 管理员查看足迹
     *
     * @param userId: Integer
     * @param goodsId: Integer
     * @param page: Integer
     * @param limit: Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> listFootprintsByCondition(Integer userId, Integer goodsId, Integer page, Integer limit);

    /**
     * 内部接口：提供给Goods模块，增加用户足迹
     *
     * @param footprintItemPo: FootprintItemPo
     * @return FootprintItemPo
     */
    public FootprintItemPo addFootprint(FootprintItemPo footprintItemPo);
}
