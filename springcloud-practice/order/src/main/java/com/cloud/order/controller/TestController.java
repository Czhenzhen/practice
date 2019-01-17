package com.cloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * //TODO 添加类/接口功能描述
 *
 * @author changzhenzhen
 * @date 2019-01-17
 */
@Controller
@RequestMapping("/order")
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/create")
    @ResponseBody
    public String create(String name) {
        return "client1 create successful,name=" + name + ",current port = " + port;
    }
}
