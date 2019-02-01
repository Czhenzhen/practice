package com.cloud.customer.controller;

import com.cloud.customer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * 控制类
  *
  * @author  changzhenzhen
  * @date 2019-01-23
  */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/ribbon-customer")
    public String helloCustomr(){
        return helloService.helloService();
    }
}
