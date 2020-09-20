package com.blockchain.exchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxu
 * @date 2020/8/30 13:14
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("queryString")
    public String queryString() {
        return "123";
    }
}
