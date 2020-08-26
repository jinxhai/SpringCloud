package com.snailcreep.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.snailcreep.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.snailcreep.springcloud.entities.CommonResult;
import com.snailcreep.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/25
 * @Version V1.0
 **/
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException") //资源名称
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试",new Payment(2020L,"serial001"));
    }

    //兜底方法
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }


    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl") //资源名称
    public CommonResult byUrl(){
        return new CommonResult(200,"按Url名称限流测试",new Payment(2020L,"serial002"));
    }

    //配置全局兜底处理
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2") //资源名称
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义名称限流测试",new Payment(2020L,"serial003"));
    }
}
