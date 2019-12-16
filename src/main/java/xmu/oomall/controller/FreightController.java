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
     * @return
     */
    @PostMapping("/defaultFreightsPo")
    public Object addDefaultFreight(@RequestBody DefaultFreightPo defaultFreightPo)
    {
        return null;
    }

    /**
     * 更新默认运费模板
     * @param id
     * @param defaultFreightPo
     * @return
     */
    @PutMapping("/defaultFreights/{id}")
    public Object updateDefaultFreight(@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightPo){
        return null;
    }

    /*    DELETE
    /defaultFreights/{id}
    删除默认运费规则
    Pathvariable (id)*/
    @DeleteMapping("/defaultFreights/{id}")
    public boolean deleteDefaultFreight(@PathVariable Integer id){
        return freightService.deleteDefaultFreight(id);
    }




    //    GET
    //    获取默认运费规则(按件计)
    //return List<defaultFreightsPo>
    @GetMapping("/defaultPieceFreight ")
    public Object getDefaultPieceFreight(@RequestParam Integer limit,@RequestParam Integer page)
    {
        return null;
    }


//    post
// /defaultPieceFreights
//            新增默认比率
//
//    Destination
//            unitRate
//    requireDays

    @PostMapping("/defaultPieceFreightPo")
    public Object addDefaultPieceFreight(@RequestBody DefaultPieceFreightPo defaultPieceFreightPo)
    {
        return null;
    }

    /*PUT
    /defaultPieceFreight/{id}
    修改默认运费规则(按件计)
    pathvariable (id)  requestbody (defaultFreightsPo)
    return DefaultPieceFreightPo*/
    @PutMapping("/defaultPieceFreight/{id}")
    public Object updateDefaultPieceFreight(@PathVariable Integer id,@RequestBody DefaultPieceFreightPo defaultPieceFreightPo){
        return null;
    }

    /*    DELETE
    /defaultPieceFreight/{id}
    删除默认运费规则(按件计)
    Pathvariable (id)*/
    @DeleteMapping("/defaultPieceFreight/{id}")
    public boolean deleteDefaultPieceFreight(@PathVariable Integer id){
        return freightService.deleteDefaultFreight(id);
    }


    /**
     * @Description: 获取特殊运费模板
     * @param id
     * @return SpecialFreight
     */
    @GetMapping("/specialFreights/{id}")
    public SpecialFreight getSpecialFreights(@PathVariable Integer id)
    {
        return freightService.getSpecialFreights(id);
    }


    /*    POST
    /specialFreights
    新增默认运费规则
    requestbody specialFreights
    return specialFreights*/
    @PostMapping("/specialFreights")
    public Object addSpecialFreight(@RequestBody SpecialFreight specialFreights)
    {
        return null;
    }

    /*PUT
    /specialFreights/{id}
    修改默认运费规则
    pathvariable (id)  requestbody (specialFreight)
    return specialFreight*/
    @PutMapping("/specialFreights/{id}")
    public Object updateSpecialFreights(@PathVariable Integer id,@RequestBody SpecialFreight specialFreight){
        return null;
    }

    /*    DELETE
    /specialFreights/{id}
    删除默认运费规则
    Pathvariable (id)*/
    @DeleteMapping("/specialFreights/{id}")
    public boolean deleteSpecialFreights(@PathVariable Integer id){
        return freightService.deleteSpecialFreights(id);
    }
}