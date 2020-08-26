package com.snailcreep.springcloud.service.impl;

import com.snailcreep.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName IMessageProviderImpl
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/13
 * @Version V1.0
 **/
@EnableBinding(Source.class) //定义消息的推送管道 (生产者)
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送通道(频道)

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build()); //通过消息绑定器绑定
        System.out.println("*****uuid***" + uuid);
        return uuid;
    }
}
