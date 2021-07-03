package org.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //配置负载均衡实现RestTemplate
    // AvailabilityFilteringRule:会先过滤掉,崩溃的服务
    //RoundRobinRule 轮询(默认)
    //RandomRule 随机
    //RetryRule :会先按照轮询获取服务,服务获取失败则会在指定的时间内进行重试
    @LoadBalanced//Ribbon
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }
}
