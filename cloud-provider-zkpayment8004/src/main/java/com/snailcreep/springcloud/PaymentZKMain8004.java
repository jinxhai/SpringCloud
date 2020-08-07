package com.snailcreep.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentMain8001
 * @Description: TODO 微服务提供者
 * @Author JinXueHai
 * @Date 2020/8/3
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZKMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentZKMain8004.class,args);
    }


}
