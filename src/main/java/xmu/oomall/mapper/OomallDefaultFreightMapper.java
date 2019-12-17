package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Param;import xmu.oomall.domain.DefaultFreightPo;import java.util.List;

public interface OomallDefaultFreightMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteDefaultFreight(Integer id);

    /**
     * 查（测试用）
     * @param id
     * @return
     */
    DefaultFreightPo findAllById(@Param("id") Integer id);

    /**
     * 增
     * @param defaultFreightPo
     * @return
     */
    int insertSelective(DefaultFreightPo defaultFreightPo);

    /**
     * 查
     * @param maxBeDeleted
     * @return
     */
    List<DefaultFreightPo> findAllByBeDeletedLessThan(@Param("maxBeDeleted") Integer maxBeDeleted);

    /**
     * 改
     * @param updated
     * @param id
     * @return
     */
    int updateById(@Param("updated")DefaultFreightPo updated,@Param("id")Integer id);

}