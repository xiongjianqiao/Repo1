package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启
public class DashBoard8061 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard8061.class,args);
    }
}
