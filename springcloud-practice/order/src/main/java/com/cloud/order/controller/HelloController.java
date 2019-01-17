package com.cloud.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
  * 调用注册中心
  *
  * @author  changzhenzhen
  * @date 2019-01-17
  */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index(){
        List<ServiceInstance> instances = client.getInstances("eurekaserver");
        String str = "";
        for (ServiceInstance instance:instances){
            str += "host:"+instance.getHost()+",port:"+instance.getPort()+",serviceId:"+instance.getServiceId()+"\n";
            logger.info("host:"+instance.getHost()+",port:"+instance.getPort()+",serviceId:"+instance.getServiceId());
        }
        return str;
    }

}
