package xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("xmu.oomall.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class OomallApplication {

//    @Bean
//    public RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectionRequestTimeout(30 * 1000);
//        httpRequestFactory.setConnectTimeout(30 * 3000);
//        httpRequestFactory.setReadTimeout(30 * 3000);
//        return new RestTemplate(httpRequestFactory);
//    }


    public static void main(String[] args) {
        SpringApplication.run(OomallApplication.class, args);
    }

}
