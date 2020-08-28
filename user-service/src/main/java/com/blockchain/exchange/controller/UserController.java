package com.blockchain.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangxu
 * @date 2020/7/5 17:34
 * @description
 */
@RequestMapping("/user")
@RestController
@RefreshScope
public class UserController {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Value("${pcUrl}")
    private String pcUrl;

    @GetMapping("/queryUser")
    public String queryUser() {
        return restTemplate.getForObject("http://order/order/queryOrder", String.class);
    }

    @GetMapping("/test")
    public String test() {
        return pcUrl;
    }
}
