package xmu.oomall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "orderService")

/**
 * @Author yijunL
 * @create 2019/12/13 14:20
 */
public interface OrderItemValidate {
    @GetMapping("/orderItem/{orderItemId}/goodsType")
    int validate(Integer orderItemId);
}
