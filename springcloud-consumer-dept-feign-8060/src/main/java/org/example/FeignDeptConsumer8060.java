package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"org.example"})
public class FeignDeptConsumer8060 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer8060.class,args);
    }
}
