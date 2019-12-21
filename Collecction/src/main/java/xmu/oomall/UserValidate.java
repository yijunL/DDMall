package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "userInfoService")
public interface UserValidate {
    @GetMapping("/user/validate")
    boolean validate(Integer userId);
}
