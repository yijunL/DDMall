package xmu.oomall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.oomall.domain.User;


/**
 * @Author 24320172203121
 *
 */

@FeignClient("3-1-USER-SERVICE")
public interface AddUser {


    /**
     * 判断用户是否有效

     *@return true/false
     * @param  userId: 用户ID
     */

    @RequestMapping(value = "/user/validate", method = RequestMethod.GET)
    boolean beValidate(@PathVariable("id") Integer userId);
}
