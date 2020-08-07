package com.snailcreep.springcloud.service;

import com.snailcreep.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/3
 * @Version V1.0
 **/
public interface PaymentService {
    public int add(Payment payment);

    public Payment getPaymentById(Long id);
}
