package com.snailcreep.springcloud.controller;

import com.snailcreep.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendMessageController
 * @Description: TODO localhost:8801/sendMessage
 * @Author JinXueHai
 * @Date 2020/8/13
 * @Version V1.0
 **/
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProvider.send();
    }
}
