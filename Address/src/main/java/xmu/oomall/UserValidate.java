package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author lyj
 * @Description: UserValidate
 * @create 2019/12/16 20:49
 */
@FeignClient(value = "userInfoService")
public interface UserValidate {
    /**
     * 验证用户id
     * @param userId
     * @return
     */
    @GetMapping("/user/validate")
    boolean validate(Integer userId);
}
