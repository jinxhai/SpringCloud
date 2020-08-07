package com.snailcreep.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @MethodName: ApplicationContextConfig
 * @Description: TODO 配置类
 * @Author: JinXueHai
 * @Date: 2020/8/3
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
