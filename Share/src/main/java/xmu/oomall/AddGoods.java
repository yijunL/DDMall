package xmu.oomall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import xmu.oomall.domain.Goods;

@FeignClient(value = "goodsInfoService")
public interface AddGoods {

    @PostMapping("/goods/{id}/isOnSale")
    boolean isOnsale(Integer id);

}
