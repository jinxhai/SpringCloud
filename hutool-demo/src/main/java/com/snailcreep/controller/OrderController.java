package com.snailcreep.controller;

import com.snailcreep.util.IdGeneratorSnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName OrderController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/26
 * @Version V1.0
 **/
@RestController
public class OrderController {

    @Autowired
    private IdGeneratorSnowFlake idGeneratorSnowFlake;

    @GetMapping("/getId")
    public String getId(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i <=2; i++) {
             threadPool.submit( ()->{
                 System.out.println(idGeneratorSnowFlake.snowflakeId());
             } );
        }
        threadPool.shutdown();
    return "success";
    }

}
