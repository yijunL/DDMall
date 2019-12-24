package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Log;

/**
 * @Author 24320172203121
 *
 */

@FeignClient("2-6-LOG-SERVICE")
public interface AddLog {

    /**
     * 写日志

     *@return Log
     * @param  log:日志
     */

    @RequestMapping(value="/log", method=RequestMethod.POST)
    Log addLog(@RequestBody Log log);




}
