package go.fraczek.apisw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiSwApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSwApplication.class, args);
    }
}
