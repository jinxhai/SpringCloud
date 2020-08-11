package com.snailcreep.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName GateWayConfig
 * @Description: TODO 第二种方式实现路由
 * @Author JinXueHai
 * @Date 2020/8/10
 * @Version V1.0
 **/
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocatot(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_snailcreep", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}
