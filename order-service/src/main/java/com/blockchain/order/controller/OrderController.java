package com.blockchain.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxu
 * @date 2020/7/5 17:40
 * @description
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/queryOrder")
    public String queryOrder() {
        return "query all order" + port;
    }
}
