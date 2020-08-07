package com.snailcreep.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderFeignMain80
 * @Description: TODO 客户消费者
 * @Author JinXueHai
 * @Date 2020/8/3
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class) //自定义Ribbon 负载均衡的算法机制
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
