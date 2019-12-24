package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Log;


@FeignClient("2-6-LOG-SERVICE")
public interface AddLog {


    @RequestMapping(value="/log", method=RequestMethod.POST)
    Log addLog(@RequestBody Log log);




}
