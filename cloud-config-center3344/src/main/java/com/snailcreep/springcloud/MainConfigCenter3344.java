package com.snailcreep.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName MainConfigCenter3344
 * @Description: TODO SpringCloud Config 服务端
 *               http://config-3344.com:3344/config-dev.yml
 * @Author JinXueHai
 * @Date 2020/8/11
 * @Version V1.0
 **/
@SpringBootApplication
@EnableConfigServer
public class MainConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainConfigCenter3344.class, args);
        System.setProperty("https.proxySet", "true");
        System.setProperty("https.proxyHost","10.1.249.61");
        System.setProperty("https.proxyPort","3128");
    }
}
