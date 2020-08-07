package com.snailcreep.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRule
 * @Description: TODO Ribbon负载均衡配置类（默认为轮询）
 * @Author JinXueHai
 * @Date 2020/8/7
 * @Version V1.0
 **/
//@Configuration
public class MySelfRule {

    /*
        随机算法
     */
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }

    /*
        一定时限内循环重试 算法
     */
//    @Bean
//    public IRule myRule() {
//        return new RetryRule();
//    }

    /*
     响应速度越快的权重越大 算法
  */
//    @Bean
//    public IRule myRule() {
//        return new WeightedResponseTimeRule();
//    }

     /*
     会先过滤多次访问有故障并且断路器跳闸的服务,然后选择一个并发较小的服务 算法
  */
//    @Bean
//    public IRule myRule() {
//        return new BestAvailableRule();
//    }

       /*
     会先过滤有故障的服务,然后选择一个并发较小的服务 算法
        */
//    @Bean
//    public IRule myRule() {
//        return new AvailabilityFilteringRule();
//    }


   /*
     根据服务所在区域的服务器性能选择 算法
  */
    @Bean
    public IRule myRule() {
        return new ZoneAvoidanceRule();
    }


}
