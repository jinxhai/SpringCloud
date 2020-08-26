package com.snailcreep.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiveMessageListenerController
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/13
 * @Version V1.0
 **/
@Component
@EnableBinding(Sink.class) //消费者
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) //监听输入源
    public void input(Message<String> message) {
        System.out.println("消费者1，-------" + message.getPayload() + "\t port:" + serverPort);
    }
}
