package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import xmu.oomall.domain.Product;

@FeignClient(value = "goodsService")
public interface ProductValidate {
    @GetMapping("/user/product/{id}")
    Product validate(Integer productId);

}
