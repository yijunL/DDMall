package xmu.oomall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.oomall.domain.Goods;

/**
 * @Author 24320172203121
 *
 */
@FeignClient("2-6-GOODS-SERVICE")
public interface AddGoods {

    /**
     * 判断商品是否销售
     *@return true/false
     * @param  id:商品ID
     */

    @RequestMapping(value = "/goods/{id}/isOnSale", method = RequestMethod.GET)
    boolean isOnsale(@PathVariable("id") Integer id);

}
