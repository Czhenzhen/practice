package com.cloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 注册为消费者服务
 *
 * @author changzhenzhen
 * date 2019-01-17
 * @return
 **/
//@SpringBootApplication
//@EnableEurekaClient//注册为eureka客户端，以获得服务发现功能
///*@EnableDiscoveryClient*/
//@EnableCircuitBreaker//开启断路器功能
@SpringCloudApplication//此注解为SpringBootApplication+EnableDiscoveryClient+EnableCircuitBreaker
public class CustomerApplication {

    /**
     * 开启ribbon负载均衡支持
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}

