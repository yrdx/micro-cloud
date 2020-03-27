package com.yrdx.sms.listener;

import com.yrdx.sms.utils.SmsUtil;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 短信监听类
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 10:49
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;
    /**
     * 发送短信
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        try {
            smsUtil.sendSms(message.get("mobile"),template_code,sign_name," {\"number\":\""+ message.get("code") +"\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
