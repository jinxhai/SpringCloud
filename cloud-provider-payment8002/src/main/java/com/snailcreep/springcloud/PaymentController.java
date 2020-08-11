package com.snailcreep.springcloud;

import com.alibaba.druid.sql.visitor.functions.If;
import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import com.snailcreep.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentContrllor
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/3
 * @Version V1.0
 **/
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String SERVER_PORT;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("*****插入数据**********");
        if (result > 0) {
            return new CommonResult(200, "插入成功,server_port:" + SERVER_PORT, result);
        } else {
            return new CommonResult(201, "插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****根据id查询数据,id为" + id + "**********");
        if (payment != null) {
            return new CommonResult(200, "查询成功,server_port:" + SERVER_PORT, payment);
        } else {
            return new CommonResult(201, "没有对应的查询记录,查询id为" + id);
        }
    }

    /*
        获取服务信息
     */
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element:\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return this.SERVER_PORT;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return SERVER_PORT;
    }
}
