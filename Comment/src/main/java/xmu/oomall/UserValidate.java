package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import xmu.oomall.domain.Product;

@FeignClient(value = "authService")
public interface UserValidate {
    @GetMapping("/user")
    Product validate(Integer productId);

}
