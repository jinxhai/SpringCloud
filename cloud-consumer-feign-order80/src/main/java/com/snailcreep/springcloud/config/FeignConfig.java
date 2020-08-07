package com.snailcreep.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName FeignConfig
 * @Description: TODO FeignConfig配置类
 * @Author JinXueHai
 * @Date 2020/8/7
 * @Version V1.0
 **/
@Configuration
public class FeignConfig {

    /**
     * feignClient日志级别配置
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
