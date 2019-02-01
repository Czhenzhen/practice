package com.cloud.customer.controller;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.List;

/**
  *
  *
  * @author  changzhenzhen
  * @date 2019-01-17
  */

@Controller
@RequestMapping("/customer")
public class TestController {

    //发现服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/test1")
    @ResponseBody
    public String testOrderWithEureka() throws IOException {
       List<ServiceInstance> instances =  discoveryClient.getInstances("order");

       ServiceInstance instance = instances.get(0);
       String host = instance.getHost();
       int port = instance.getPort();
       String url = "http://"+host+":"+port+"/order/create?name=zhangsan";
        HttpClient httpClient=new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String str = "";
        if (200 == httpResponse.getStatusLine().getStatusCode()){
            str= EntityUtils.toString(httpResponse.getEntity());
        }
        return str;
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test2")
    @ResponseBody
    public String test2()throws Exception{
       return restTemplate.getForObject("http://order/hello",String.class);
    }

}
