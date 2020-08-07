package com.snailcreep.springcloud.service;

import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentFeignService
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/7
 * @Version V1.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //注册的微服务
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 模拟feign超时
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
