package com.snailcreep.springcloud.service;

import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/25
 * @Version V1.0
 **/
@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id );
}
