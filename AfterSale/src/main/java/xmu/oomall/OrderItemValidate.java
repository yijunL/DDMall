package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "orderService")
public interface OrderItemValidate {
    @GetMapping("/orderItem/{orderItemId}/goodsType")
    int validate(Integer orderItemId);
}
