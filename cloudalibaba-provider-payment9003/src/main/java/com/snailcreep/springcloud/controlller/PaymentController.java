package com.snailcreep.springcloud.controlller;

import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName PaymentController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/25
 * @Version V1.0
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,Payment> hashMap= new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"123"));
        hashMap.put(2L,new Payment(2L,"456"));
        hashMap.put(3L,new Payment(3L,"789"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id ){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> commonResult = new CommonResult(200, "from mysql , serverPOrt: " + serverPort, payment);
        return commonResult;
    }

}
