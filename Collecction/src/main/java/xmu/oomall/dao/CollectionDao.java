package xmu.oomall.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.UserValidate;
import xmu.oomall.domain.CollectItem;
import xmu.oomall.domain.CollectItemPo;
import xmu.oomall.mapper.OomallCollectItemMapper;
import xmu.oomall.util.Copyer;
import xmu.oomall.util.PageCut;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyj
 */
@Repository
public class CollectionDao {

    @Autowired
    private OomallCollectItemMapper oomallCollectItemMapper;



    /**
     * 用户查看收藏列表
     *
     * @param userId: Integer
     * @param page：Integer
     * @param limit：Integer
     * @return List<CollectItem>
     */
    public List<CollectItem> getColltectionList(Integer userId,Integer page,Integer limit)
    {
        return (List<CollectItem>) PageCut.pageCut(oomallCollectItemMapper.findAllById(userId),page,limit);
    }

    public CollectItemPo addCollection(CollectItemPo collectItemPo)
    {
            collectItemPo.setGmtCreate(LocalDateTime.now());
            collectItemPo.setGmtModified(LocalDateTime.now());

        oomallCollectItemMapper.insertSelective(collectItemPo);
        return collectItemPo;
    }

    /**
     * 用户删除收藏
     *
     * @param id：Integer
     * @return null
     */
    public boolean deleteCollection(Integer id) {
        List<CollectItemPo> collectItemPo=oomallCollectItemMapper.findAllById(id);
        if(collectItemPo.isEmpty())
        {return false;}
        return oomallCollectItemMapper.deleteById(id);
    }

}