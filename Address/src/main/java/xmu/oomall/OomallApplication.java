package xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 3204
 * @Description: OomallApplication
 * @create 2019/12/16 20:49
 */
@SpringBootApplication
@MapperScan("xmu.oomall.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class OomallApplication {

    public static void main(String[] args) {
        SpringApplication.run(OomallApplication.class, args);
    }

}
