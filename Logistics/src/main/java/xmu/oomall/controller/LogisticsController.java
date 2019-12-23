package xmu.oomall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author YijunL
 * @Description: LogisticsController
 * @create 2019/12/13 13:30
 */
@RestController
@RequestMapping("/logisticsService")//
public class LogisticsController {

    /**
     * 随机返回不重复的物流编号
     * @return
     */
    @GetMapping("/logistics")
    public Object getLogistics() {
        Random random = new Random();
        Integer a = random.nextInt(10000);
        String data=LocalDateTime.now().toString()+a.toString();
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data", data);
        return obj;
    }
}