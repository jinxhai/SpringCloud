package com.snailcreep.springcloud.service;

import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/25
 * @Version V1.0
 **/
@Component
public class PaymentFallbackService implements  PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回----PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
