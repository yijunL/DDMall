package xmu.oomall.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xmu.oomall.controller.FootprintController;
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
     * @param page：Integer
     * @param limit：Integer
     * @return List<FootprintItem>
     */
    public List<FootprintItem> listFootprintsByPage(Integer page, Integer limit);

    /**
     * 用户删除足迹
     *
     * @param id：Integer
     * @return Response.ok()
     */
    public Boolean deleteFootprintById (Integer id);

    /**
     * 用户删除足迹
     *
     * @return List<FootprintItem>
     */
    public List<FootprintItem> listFootprintsByCondition();
}
