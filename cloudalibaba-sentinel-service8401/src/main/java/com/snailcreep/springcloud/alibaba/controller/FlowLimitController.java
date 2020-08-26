package com.snailcreep.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowLimitController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/24
 * @Version V1.0
 **/
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "----------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "----------testB";
    }

    @GetMapping("/testE")
    public String testE(){
        int a = 1/0;
        return "----------testE 测试异常数";
    }



}
