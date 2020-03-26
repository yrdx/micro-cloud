package com.yrdx.base.controller;

import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理
 */
@RestControllerAdvice
public class LabelExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false,StatusCode.ERROR,  e.getMessage());
    }
}
