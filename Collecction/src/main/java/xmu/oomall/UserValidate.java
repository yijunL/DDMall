package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Lyj
 * 使用feign来调用远程服务
 */
@FeignClient(value = "userInfoService")
public interface UserValidate {
    /**
     * feign接口类
     * @param userId
     * @return
     */
    @GetMapping("/user/validate")
    boolean validate(Integer userId);
}
