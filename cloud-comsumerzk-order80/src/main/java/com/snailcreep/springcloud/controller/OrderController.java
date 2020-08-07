package com.snailcreep.springcloud.controller;

import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/3
 * @Version V1.0
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

//    public static final String PAYMENT_URL="http://localhost:8001"; //单机
    public static final String PAYMENT_URL="http://cloud-provider-payment"; //集群

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/payment/zk")
    public String get() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return result;
    }


}
