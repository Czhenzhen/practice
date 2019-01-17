package com.cloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注册为消费者服务
 *
 * @author changzhenzhen
 * date 2019-01-17
 * @return
 **/
@SpringBootApplication
@EnableEurekaClient//注册为eureka客户端，以获得服务发现功能
/*@EnableDiscoveryClient*/
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}

