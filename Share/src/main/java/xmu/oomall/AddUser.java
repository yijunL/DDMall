package xmu.oomall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.oomall.domain.User;

@FeignClient("3-1-USER-SERVICE")
public interface AddUser {

    @RequestMapping(value = "/user/validate", method = RequestMethod.GET)
    boolean beValidate(@PathVariable("id") Integer userId);
}
