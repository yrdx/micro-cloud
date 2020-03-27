package com.yrdx.user.controller;

import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;
import com.yrdx.user.pojo.User;
import com.yrdx.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 10:12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送短信验证码
     */
    @RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendSms(@PathVariable String mobile){
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK, "发送成功");
    }

    /**
     * 用户注册
     * @param user
     * @param code
     * @return
     */
    @RequestMapping(value="/register/{code}",method=RequestMethod.POST)
    public Result register( @RequestBody User user ,@PathVariable String code) {
        userService.add(user,code);
        return new Result(true,StatusCode.OK,"注册成功");
    }
}
