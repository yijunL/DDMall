package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;
import xmu.oomall.service.FreightService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/admin-freightService")// /wx/order

/**
 * @Author YijunL
 * @Description: FootprintController
 * @create 2019/12/12 13:30
 */

public class FreightController {
    @Autowired
    private FreightService freightService;

    /**
     * 解析请求
     * @param request
     * @return
     */
    private Integer getUserId(HttpServletRequest request) {
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null) {
            return null;
        }
        return Integer.valueOf(userIdStr);
    }

    /**
     * 获取默认运费规则（按件计）
     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/defaultPieceFreights")
    public Object getDefaultPieceFreightsList(HttpServletRequest request,@RequestParam Integer page, @RequestParam Integer limit) {
        Integer userId=getUserId(request);
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        // 参数校验
        if (page == null || page < 0) {
            return ResponseUtil.badArgumentValue();
        }
        if (limit == null || limit < 0) {
            return ResponseUtil.badArgumentValue();
        }
        List<DefaultPieceFreightPo> defaultPieceFreightPoList=freightService.getDefaultPieceFreightsList(page, limit);
        return ResponseUtil.ok(defaultPieceFreightPoList);
    }

    /**
     * 新增默认运费规则（按件计）
     * @param request
     * @param defaultPieceFreightPo
     * @return
     */
    @PostMapping("/defaultPieceFreights")
    public Object addDefaultPieceFreight(HttpServletRequest request, @RequestBody DefaultPieceFreightPo defaultPieceFreightPo)
    {
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        //参数校验
        if((defaultPieceFreightPo.getDestination()==null)||(defaultPieceFreightPo.getUnitRate()==null)||
                (defaultPieceFreightPo.getRequireDays()==null)) {
            return ResponseUtil.badArgument();
        }
        DefaultPieceFreightPo defaultPieceFreightPo1=freightService.addDefaultPieceFreight(defaultPieceFreightPo);
        if(defaultPieceFreightPo1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(defaultPieceFreightPo1);
    }

    /**
     * 管理员获取商品的产品信息
     * @param request
     * @param id
     * @param defaultPieceFreightPo
     * @return
     */
    @PutMapping("/defaultPieceFreights/{id}")
    public Object updateDefaultPieceFreight(HttpServletRequest request, @PathVariable Integer id,
                                            @RequestBody DefaultPieceFreightPo defaultPieceFreightPo){

        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        //参数校验
        if((defaultPieceFreightPo.getDestination()==null)||(defaultPieceFreightPo.getUnitRate()==null)||
                (defaultPieceFreightPo.getRequireDays()==null)) {
            return ResponseUtil.badArgument();
        }
        if(id==null || id < 0){
            return ResponseUtil.badArgument();
        }
        DefaultPieceFreightPo defaultPieceFreightPo1 = freightService.updateDefaultPieceFreight(id,defaultPieceFreightPo);
        if(defaultPieceFreightPo1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(defaultPieceFreightPo1);
    }

    /**
     * 删除默认运费规则（按件计）
     * @param request
     * @param id
     * @return
     */
    @DeleteMapping("/defaultPieceFreights/{id}")
    public Object deleteDefaultPieceFreight(HttpServletRequest request, @PathVariable Integer id){
        Integer userId = getUserId(request);
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        // 参数校验
        if (id == null || id < 0) {
            return ResponseUtil.badArgument();
        }
        if(freightService.deleteDefaultPieceFreight(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }

    /**
     * @param limit
     * @param page
     * @return List<DefaultFreightPo>
     * @Description: 获取所有默认运费模板
     */
    @GetMapping("/defaultFreights")
    public Object getDefaultFreights(@RequestParam Integer page, @RequestParam Integer limit) {
        if (page == null || limit == null)
            return ResponseUtil.badArgument();
        List<DefaultFreightPo> defaultFreightPoList = freightService.getDefaultFreights(page, limit);
        if (defaultFreightPoList == null || defaultFreightPoList.isEmpty())
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(defaultFreightPoList);

    }


    /**
     * @param defaultFreightPo
     * @return DefaultFreightPo
     * @Description: 添加一个运费模板
     */
    @PostMapping("/defaultFreights")
    public Object addDefaultFreight(@RequestBody DefaultFreightPo defaultFreightPo) {
        if (defaultFreightPo == null)
            return ResponseUtil.badArgument();
        DefaultFreightPo defaultFreightPo1 = freightService.addDefaultFreight(defaultFreightPo);

        if (defaultFreightPo == null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(defaultFreightPo1);
    }

    /**
     * 更新默认运费模板
     *
     * @param id
     * @param defaultFreightPo
     * @return DefaultFreightPo
     */
    @PutMapping("/defaultFreights/{id}")
    public Object updateDefaultFreight(@PathVariable Integer id, @RequestBody DefaultFreightPo defaultFreightPo) {

        if (id == null || defaultFreightPo == null)
            return ResponseUtil.badArgument();
        DefaultFreightPo defaultFreightPo1 = freightService.updateDefaultFreight(id, defaultFreightPo);
        if (defaultFreightPo == null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(defaultFreightPo1);
    }

    /**
     * 删除默认运费模板
     *
     * @param id
     * @return boolean
     */
    @DeleteMapping("/defaultFreights/{id}")
    public Object deleteDefaultFreight(@PathVariable Integer id) {
        if (id == null)
            return ResponseUtil.badArgument();
        if (freightService.deleteDefaultFreight(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }


    /**
     * 获取默认计件运费模板
     *
     * @param limit
     * @param page
     * @return List<DefaultPieceFreightPo>
     */
    @GetMapping("/defaultPieceFreight ")
    public List<DefaultPieceFreightPo> getDefaultPieceFreight(@RequestParam Integer page, @RequestParam Integer limit) {
        return null;
    }


    /**
     * 新增默认计件运费模板
     *
     * @param defaultPieceFreightPo
     * @return DefaultPieceFreightPo
     */
    @PostMapping("/defaultPieceFreightPo")
    public DefaultPieceFreightPo addDefaultPieceFreight(@RequestBody DefaultPieceFreightPo defaultPieceFreightPo) {
        return null;
    }

    /**
     * 修改默认计件运费模板
     *
     * @param id
     * @param defaultPieceFreightPo
     * @return
     */
    @PutMapping("/defaultPieceFreight/{id}")
    public DefaultPieceFreightPo updateDefaultPieceFreight(@PathVariable Integer id, @RequestBody DefaultPieceFreightPo defaultPieceFreightPo) {
        return null;
    }

    /**
     * 删除默认计件运费模板
     *
     * @param id
     * @return boolean
     */
    @DeleteMapping("/defaultPieceFreight/{id}")
    public Object deleteDefaultPieceFreight(@PathVariable Integer id) {
        return null;
    }


    /**
     * @param id
     * @return SpecialFreight
     * @Description: 通过id获取特殊运费模板
     */
    @GetMapping("/specialFreights/{id}")
    public Object getSpecialFreights(@PathVariable Integer id) {
        if (id == null)
            return ResponseUtil.badArgument();
        SpecialFreight specialFreight = freightService.getSpecialFreights(id);
        if (specialFreight == null)
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(specialFreight);
    }

    /**
     * 获取所有特殊运费模板
     *
     * @param page
     * @param limit
     * @return List<SpecialFreight>
     */
    @GetMapping("/specialFreights")
    public Object getAllSpecialFreights(@RequestParam Integer page, @RequestParam Integer limit) {
        if (page == null || limit == null)
            return ResponseUtil.badArgument();
        List<SpecialFreight> specialFreightList = freightService.getAllSpecialFreight(page, limit);
        if (specialFreightList == null || specialFreightList.isEmpty())
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(specialFreightList);
    }


    /**
     * 添加特殊运费模板
     *
     * @param specialFreights
     * @return SpecialFreight
     */
    @PostMapping("/specialFreights")
    public Object addSpecialFreight(@RequestBody SpecialFreight specialFreights) {
        if (specialFreights == null)
            return ResponseUtil.badArgument();
        SpecialFreight specialFreight = freightService.addSpecialFreight(specialFreights);
        if (specialFreight == null)
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(specialFreight);
    }

    /**
     * 更新特殊运费模板
     *
     * @param id
     * @param specialFreight
     * @return SpecialFreight
     */
    @PutMapping("/specialFreights/{id}")
    public Object updateSpecialFreights(@PathVariable Integer id, @RequestBody SpecialFreight specialFreight) {
        if (id == null || specialFreight == null)
            return ResponseUtil.badArgument();
        else {
            SpecialFreight specialFreight1 = freightService.updateSpecialFreights(id, specialFreight);
            if (specialFreight == null)
                return ResponseUtil.updatedDataFailed();
            else
                return ResponseUtil.ok(specialFreight1);
        }
    }

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return boolean
     */
    @DeleteMapping("/specialFreights/{id}")
    public Object deleteSpecialFreights(@PathVariable Integer id) {
        if (id == null)
            return ResponseUtil.badArgument();
        if (freightService.deleteSpecialFreights(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }

    @GetMapping("/freightPrice")
    public BigDecimal getFreightPrice(@RequestBody Order order) {
        if (order == null)
            return null;
        return null;
    }
}