package com.snailcreep.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderNacosMain83
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/17
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient //注册服务中心
public class OrderNacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain84.class, args);
    }
}
