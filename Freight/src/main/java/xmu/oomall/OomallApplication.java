package xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@MapperScan("xmu.oomall.mapper")
@EnableDiscoveryClient
public class OomallApplication {

    public static void main(String[] args) {
        SpringApplication.run(OomallApplication.class, args);
    }

}
