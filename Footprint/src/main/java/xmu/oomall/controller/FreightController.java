package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.DefaultPieceFreightPo;
import xmu.oomall.domain.Order;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;
import xmu.oomall.util.ResponseUtil;

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
     * @Description: 获取所有默认运费模板
     * @param limit
     * @param page
     * @return List<DefaultFreightPo>
     */
    @GetMapping("/defaultFreights")
    public Object getDefaultFreights(@RequestParam Integer page, @RequestParam Integer limit)
    {
        if(page==null||limit==null)
            return ResponseUtil.badArgument();
        List<DefaultFreightPo>defaultFreightPoList= freightService.getDefaultFreights(page,limit);
        if(defaultFreightPoList==null||defaultFreightPoList.isEmpty())
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(defaultFreightPoList);

    }


    /**
     * @Description: 添加一个运费模板
     * @param defaultFreightPo
     * @return DefaultFreightPo
     */
    @PostMapping("/defaultFreightsPo")
    public Object addDefaultFreight(@RequestBody DefaultFreightPo defaultFreightPo)
    {
        if(defaultFreightPo==null)
            return ResponseUtil.badArgument();
        DefaultFreightPo defaultFreightPo1=freightService.addDefaultFreight(defaultFreightPo);

        if(defaultFreightPo==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(defaultFreightPo1);
    }

    /**
     * 更新默认运费模板
     * @param id
     * @param defaultFreightPo
     * @return DefaultFreightPo
     */
    @PutMapping("/defaultFreights/{id}")
    public Object updateDefaultFreight(@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightPo){

        if(id==null || defaultFreightPo==null)
            return ResponseUtil.badArgument();
        DefaultFreightPo defaultFreightPo1=freightService.updateDefaultFreight(id,defaultFreightPo);
        if(defaultFreightPo==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(defaultFreightPo1);
    }

    /**
     * 删除默认运费模板
     * @param id
     * @return boolean
     */
    @DeleteMapping("/defaultFreights/{id}")
    public Object deleteDefaultFreight(@PathVariable Integer id){
        if(id==null)
            return ResponseUtil.badArgument();
        if(freightService.deleteDefaultFreight(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }


    /**
     * 获取默认计件运费模板
     * @param limit
     * @param page
     * @return List<DefaultPieceFreightPo>
     */
    @GetMapping("/defaultPieceFreight ")
    public List<DefaultPieceFreightPo> getDefaultPieceFreight(@RequestParam Integer page,@RequestParam Integer limit)
    {
        return null;
    }


    /**
     * 新增默认计件运费模板
     * @param defaultPieceFreightPo
     * @return DefaultPieceFreightPo
     */
    @PostMapping("/defaultPieceFreightPo")
    public DefaultPieceFreightPo addDefaultPieceFreight(@RequestBody DefaultPieceFreightPo defaultPieceFreightPo)
    {
        return null;
    }

    /**
     * 修改默认计件运费模板
     * @param id
     * @param defaultPieceFreightPo
     * @return
     */
    @PutMapping("/defaultPieceFreight/{id}")
    public DefaultPieceFreightPo updateDefaultPieceFreight(@PathVariable Integer id,@RequestBody DefaultPieceFreightPo defaultPieceFreightPo){
        return null;
    }

    /**
     * 删除默认计件运费模板
     * @param id
     * @return boolean
     */
    @DeleteMapping("/defaultPieceFreight/{id}")
    public Object deleteDefaultPieceFreight(@PathVariable Integer id){
        return null;
    }


    /**
     * @Description: 通过id获取特殊运费模板
     * @param id
     * @return SpecialFreight
     */
    @GetMapping("/specialFreights/{id}")
    public Object getSpecialFreights(@PathVariable Integer id)
    {
        if(id==null)
            return ResponseUtil.badArgument();
        SpecialFreight specialFreight= freightService.getSpecialFreights(id);
        if(specialFreight==null)
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(specialFreight);
    }

    /**
     * 获取所有特殊运费模板
     * @param page
     * @param limit
     * @return List<SpecialFreight>
     */
    @GetMapping("/specialFreights")
    public Object getAllSpecialFreights(@RequestParam Integer page,@RequestParam Integer limit)
    {
        if(page==null||limit==null)
            return ResponseUtil.badArgument();
        List<SpecialFreight> specialFreightList= freightService.getAllSpecialFreight(page,limit);
        if(specialFreightList==null|| specialFreightList.isEmpty())
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(specialFreightList);
    }


    /**
     * 添加特殊运费模板
     * @param specialFreights
     * @return SpecialFreight
     */
    @PostMapping("/specialFreights")
    public Object addSpecialFreight(@RequestBody SpecialFreight specialFreights)
    {
        if(specialFreights==null)
            return ResponseUtil.badArgument();
        SpecialFreight specialFreight=freightService.addSpecialFreight(specialFreights);
        if(specialFreight==null)
            return ResponseUtil.badArgumentValue();
        else
            return ResponseUtil.ok(specialFreight);
    }

    /**
     * 更新特殊运费模板
     * @param id
     * @param specialFreight
     * @return SpecialFreight
     */
    @PutMapping("/specialFreights/{id}")
    public Object updateSpecialFreights(@PathVariable Integer id,@RequestBody SpecialFreight specialFreight){
        if(id==null||specialFreight==null)
            return ResponseUtil.badArgument();
        else
        {
            SpecialFreight specialFreight1=freightService.updateSpecialFreights(id,specialFreight);
            if(specialFreight==null)
                return ResponseUtil.updatedDataFailed();
            else
                return ResponseUtil.ok(specialFreight1);
        }
    }

    /**
     * 删除特殊运费模板
     * @param id
     * @return boolean
     */
    @DeleteMapping("/specialFreights/{id}")
    public Object deleteSpecialFreights(@PathVariable Integer id){
        if(id==null)
            return ResponseUtil.badArgument();
        if(freightService.deleteSpecialFreights(id))
            return ResponseUtil.ok();
        else
            return ResponseUtil.updatedDataFailed();
    }

    @GetMapping("/freightPrice")
    public BigDecimal getFreightPrice(@RequestBody Order order)
    {
        if(order==null)
            return null;
        return null;
    }
}