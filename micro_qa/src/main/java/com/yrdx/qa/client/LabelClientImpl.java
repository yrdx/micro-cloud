package com.yrdx.qa.client;

import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;

import org.springframework.stereotype.Component;

/**
 * 熔断后调用的接口
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 16:32
 */
@Component
public class LabelClientImpl implements LabelClient{
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR,"获取标签失败，请稍后重试");
    }
}
