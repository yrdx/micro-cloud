package com.yrdx.sms.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 11:06
 */
@Configuration
public class MQConfig {

    private static final String SMS_QUEUE = "sms";
    @Bean
    public Queue queue(){
        return new Queue(SMS_QUEUE,true);
    }
}
