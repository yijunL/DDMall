package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "userInfoService")
/**
 * @Author yijunL
 * @create 2019/12/12 13:30
 */
public interface UserValidate {
    @GetMapping("/user/validate")
    boolean validate(Integer userId);
}
