package com.cloud.customer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
  *
  *
  * @author  changzhenzhen
  * @date 2019-01-23
  */

@Service
public class HelloService {


    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFailBack")
    public String helloService(){
        long start = System.currentTimeMillis();
        String str =  restTemplate.getForObject("http://order/hello",String.class);
        long end = System.currentTimeMillis();
        logger.info("执行时间为："+(end-start));
        return str;
    }

    public String helloFailBack(){
        return "error";
    }
}

