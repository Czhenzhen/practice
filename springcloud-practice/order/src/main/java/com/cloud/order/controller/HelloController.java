package com.cloud.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;


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
    public String index()throws Exception{
        List<ServiceInstance> instances = client.getInstances("eurekaserver");
        ServiceInstance instance = instances.get(0);
        //让处理的线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);

        String str = "host:"+instance.getHost()+",port:"+instance.getPort()+",serviceId:"+instance.getServiceId()+"\n";
        logger.info("host:"+instance.getHost()+",port:"+instance.getPort()+",serviceId:"+instance.getServiceId());
      /*  for (ServiceInstance instance:instances){
            str += "host:"+instance.getHost()+",port:"+instance.getPort()+",serviceId:"+instance.getServiceId()+"\n";
            logger.info("host:"+instance.getHost()+",port:"+instance.getPort()+",serviceId:"+instance.getServiceId());
        }*/
        return str;
    }

}
