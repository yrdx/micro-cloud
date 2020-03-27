package com.yrdx.user.service;

import com.yrdx.common.util.IdWorker;
import com.yrdx.user.dao.UserDao;
import com.yrdx.user.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 10:04
 */
@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserDao userDao;

    /**
     * 发送短信验证码
     * @param mobile
     */
    public void sendSms(String mobile) {
        //1、生成6位验证码
        String checkcode = RandomStringUtils.randomNumeric(6);
        //2、将验证码放入redis缓存,设置5分钟有效期
        redisTemplate.opsForValue().set("smscode_" + mobile, checkcode,5, TimeUnit.MINUTES);
       //3、将验证码和手机号发送到rabbitmq
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("code", checkcode);
        rabbitTemplate.convertAndSend("sms", map);
    }

    /**
     * 注册用户
     * @param user
     * @param code
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(User user, String code) {
        //1、验证码验证
        String checkCode = (String)redisTemplate.opsForValue().get("smscode_" + user.getMobile());
        if (StringUtils.isBlank(checkCode)) {
            throw  new RuntimeException("请点击获取短信验证码");
        }
        if(!checkCode.equals(code)){
            throw new RuntimeException("验证码输入不正确");
        }
        user.setId(idWorker.nextId()+"" );
        user.setFollowcount(0);//关注数
        user.setFanscount(0);//粉丝数
        user.setOnline(0L);//在线时长
        user.setRegdate(new Date());//注册日期
        user.setUpdatedate(new Date());//更新日期
        user.setLastdate(new Date());//最后登陆日期
        userDao.save(user);
    }
}
