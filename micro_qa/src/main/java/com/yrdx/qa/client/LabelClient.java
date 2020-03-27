package com.yrdx.qa.client;

import com.yrdx.common.result.Result;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *@FeignClient注解用于指定从哪个服务中调用功能
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 14:53
 */
@FeignClient(value = "micro-base", fallback = LabelClientImpl.class)
public interface LabelClient {

    @RequestMapping(value="/label/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}
