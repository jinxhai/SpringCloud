package com.snailcreep.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.print.PrinterGraphics;

/**
 * @ClassName IdGeneratorSnowFlake
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/26
 * @Version V1.0
 **/
@Slf4j
@Component
public class IdGeneratorSnowFlake {
    private long wokerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(wokerId, datacenterId);

    @PostConstruct
    public void init() {
        try {
            wokerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的wokerId:{}", wokerId);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("当前机器获取wokerId获取失败", e);
            wokerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long wokerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(wokerId, datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        System.out.println(new IdGeneratorSnowFlake().snowflakeId());
    }
}
