package xmu.oomall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import xmu.oomall.domain.User;

@FeignClient(value = "userInfoService")
public interface AddUser {
    @PostMapping("/user/validate")
    boolean beValidate(Integer userId);
}
