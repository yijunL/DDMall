package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import xmu.oomall.domain.*;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;

import javax.print.attribute.standard.Destination;
import javax.validation.constraints.NotNull;
@RestController
@RequestMapping("/admin-freightService")// /wx/order

public class FreightController {
    @Autowired
    private FreightService freightService;

    //    GET
    //    获取默认运费规则
    //return List<defaultFreights>
    @GetMapping("/defaultFreights")
    public Object getDefaultFreights(@RequestParam Integer limit,@RequestParam Integer page)
    {
        return null;
    }


    /*    POST
    /defaultFreights
    新增默认运费规则
    requestbody defaultFreights
    return defaultFreightsPo*/
    @PostMapping("/defaultFreights")
    public Object addDefaultFreight(@RequestBody DefaultFreightPo defaultFreightPo)
    {
        return null;
    }

    /*PUT
    /defaultFreights/{id}
    修改默认运费规则
    pathvariable (id)  requestbody (defaultFreightsPo)
    return defaultFreightsPo*/
    @PutMapping("/defaultFreights/{id}")
    public Object updateDefaultFreight(@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightPo){
        return null;
    }

    /*    DELETE
    /defaultFreights/{id}
    删除默认运费规则
    Pathvariable (id)*/
    @DeleteMapping("/defaultFreights/{id}")
    public void deleteDefaultFreight(@PathVariable Integer id){
        freightService.deleteDefaultFreight(id);
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

    @PostMapping("/defaultPieceFreight")
    public Object addDefaultPieceFreight(@RequestBody DefaultPieceFreight defaultPieceFreight)
    {
        return null;
    }

    /*PUT
    /defaultPieceFreight/{id}
    修改默认运费规则(按件计)
    pathvariable (id)  requestbody (defaultFreights)
    return DefaultPieceFreight*/
    @PutMapping("/defaultPieceFreight/{id}")
    public Object updateDefaultPieceFreight(@PathVariable Integer id,@RequestBody DefaultPieceFreight defaultPieceFreight){
        return null;
    }

    /*    DELETE
    /defaultPieceFreight/{id}
    删除默认运费规则(按件计)
    Pathvariable (id)*/
    @DeleteMapping("/defaultPieceFreight/{id}")
    public void deleteDefaultPieceFreight(@PathVariable Integer id){
    }



    //    GET
    //    获取特殊运费规则
    //return List<specialFreights>
    @GetMapping("/specialFreights")
    public Object getSpecialFreights(@RequestParam Integer limit,@RequestParam Integer page)
    {
        return null;
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
    public void deleteSpecialFreights(@PathVariable Integer id){

    }
}