package xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;


@SpringBootApplication
@MapperScan("xmu.oomall.mapper")
@EnableDiscoveryClient
@EnableFeignClients


/**
 * @Author 24320172203121
 *
 */
public class OomallApplication {

    public static void main(String[] args) {
        SpringApplication.run(OomallApplication.class, args);
    }

}
