package xmu.oomall.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import xmu.oomall.domain.*;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;

import javax.print.attribute.standard.Destination;
import javax.validation.constraints.NotNull;
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
    public List<DefaultFreightPo> getDefaultFreights(@RequestParam Integer limit, @RequestParam Integer page)
    {

        return null;
    }


    /**
     * @Description: 添加一个运费模板
     * @param defaultFreightPo
     * @return DefaultFreightPo
     */
    @PostMapping("/defaultFreightsPo")
    public DefaultFreightPo addDefaultFreight(@RequestBody DefaultFreightPo defaultFreightPo)
    {
        return null;
    }

    /**
     * 更新默认运费模板
     * @param id
     * @param defaultFreightPo
     * @return DefaultFreightPo
     */
    @PutMapping("/defaultFreights/{id}")
    public DefaultFreightPo updateDefaultFreight(@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightPo){
        return null;
    }

    /**
     * 删除默认运费模板
     * @param id
     * @return boolean
     */
    @DeleteMapping("/defaultFreights/{id}")
    public boolean deleteDefaultFreight(@PathVariable Integer id){
        return freightService.deleteDefaultFreight(id);
    }


    /**
     * 获取默认计件运费模板
     * @param limit
     * @param page
     * @return List<DefaultPieceFreightPo>
     */
    @GetMapping("/defaultPieceFreight ")
    public List<DefaultPieceFreightPo> getDefaultPieceFreight(@RequestParam Integer limit,@RequestParam Integer page)
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
    public boolean deleteDefaultPieceFreight(@PathVariable Integer id){
        return freightService.deleteDefaultFreight(id);
    }


    /**
     * @Description: 通过id获取特殊运费模板
     * @param id
     * @return SpecialFreight
     */
    @GetMapping("/specialFreights/{id}")
    public SpecialFreight getSpecialFreights(@PathVariable Integer id)
    {
        return freightService.getSpecialFreights(id);
    }

    /**
     * 获取所有特殊运费模板
     * @return List<SpecialFreight>
     */
    @GetMapping("/specialFreights")
    public List<SpecialFreight> getAllSpecialFreights()
    {
        return null;
    }


    /**
     * 添加特殊运费模板
     * @param specialFreights
     * @return SpecialFreight
     */
    @PostMapping("/specialFreights")
    public SpecialFreight addSpecialFreight(@RequestBody SpecialFreight specialFreights)
    {
        return null;
    }

    /**
     * 更新特殊运费模板
     * @param id
     * @param specialFreight
     * @return SpecialFreight
     */
    @PutMapping("/specialFreights/{id}")
    public SpecialFreight updateSpecialFreights(@PathVariable Integer id,@RequestBody SpecialFreight specialFreight){
        return null;
    }

    /**
     * 删除特殊运费模板
     * @param id
     * @return boolean
     */
    @DeleteMapping("/specialFreights/{id}")
    public boolean deleteSpecialFreights(@PathVariable Integer id){
        return freightService.deleteSpecialFreights(id);
    }
}