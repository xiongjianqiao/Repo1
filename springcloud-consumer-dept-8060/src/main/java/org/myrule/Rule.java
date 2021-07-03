package org.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rule {
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();//默认是轮询,自定义为Random()
    }
}
