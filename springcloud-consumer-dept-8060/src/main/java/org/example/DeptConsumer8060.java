package org.example;

import org.myrule.Rule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
//消费方
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载我们自定义的Ribbon类
@RibbonClient(name="springcloud-provider-dept",configuration = Rule.class)
public class DeptConsumer8060 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8060.class,args);
    }
}
