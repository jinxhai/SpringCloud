package com.snailcreep.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName LoadBalancer
 * @Description: TODO 自定义负载均衡
 * @Author JinXueHai
 * @Date 2020/8/7
 * @Version V1.0
 **/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instances);
}
