package com.snailcreep.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @Description: TODO 负载均衡实现类
 * @Author JinXueHai
 * @Date 2020/8/7
 * @Version V1.0
 **/
@Component
public class MyLB implements LoadBalancer {

    //定义点击次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问,次数next:" + next);
        return next;
    }


    /*
    轮询
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        // = 每次请求数 % 实例的总数
        int index = getAndIncrement() % instances.size();

        return instances.get(index);
    }
}
