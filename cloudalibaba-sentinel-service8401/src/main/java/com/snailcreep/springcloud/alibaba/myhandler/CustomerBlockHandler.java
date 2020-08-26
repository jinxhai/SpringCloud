package com.snailcreep.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.snailcreep.springcloud.entities.CommonResult;

/**
 * @ClassName CustomerBlockHandler
 * @Description: TODO
 * @Author JinXueHai
 * @Date 2020/8/25
 * @Version V1.0
 **/
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(4444, "自定义的限流处理信息.....Global_CustomerBlockHandler---1");
    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(4444, "自定义的限流处理信息.....Global_CustomerBlockHandler----2");
    }
}
