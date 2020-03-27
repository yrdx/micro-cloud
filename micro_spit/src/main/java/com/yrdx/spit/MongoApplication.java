package com.yrdx.spit;

import com.yrdx.common.util.IdWorker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 16:41
 */
@SpringBootApplication
@EnableEurekaClient
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
}
