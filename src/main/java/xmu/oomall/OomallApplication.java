package xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("xmu.oomall.mapper")
public class OomallApplication {

    public static void main(String[] args) {
        SpringApplication.run(OomallApplication.class, args);
    }

}
