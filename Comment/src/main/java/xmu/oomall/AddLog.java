package xmu.oomall;

        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.PostMapping;
        import xmu.oomall.domain.Log;

@FeignClient(value = "logService")
public interface AddLog {
    @PostMapping("/log")
    /** 调用Log服务
     *
     * @param  log
     * @return : log
     */
    Log addLog(Log log);
}
