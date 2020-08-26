package com.snailcreep.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import com.snailcreep.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderNacosController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/17
 * @Version V1.0
 **/
@RestController
@Slf4j
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常 ,报错直接去兜底方法
    @SentinelResource(value = "fallback", blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(serverUrl + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (result.getDate() == null) {
            throw new NullPointerException("NullPointerException,该id没有记录,空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常HandlerFallBack,exception内容 " + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常blockHandler,exception内容 " + e.getMessage(), payment);
    }


    //openFeign
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
