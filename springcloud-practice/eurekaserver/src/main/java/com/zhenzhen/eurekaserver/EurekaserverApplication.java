package com.zhenzhen.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 提供eureka服务(服务注册中心)
 *
 * @author changzhenzhen
 * date 2019-01-17
 * @return
 **/
@SpringBootApplication
//注册为一个eureka服务
@EnableEurekaServer
public class EurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication.class, args);
    }

}

