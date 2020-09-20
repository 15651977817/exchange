package com.blockchain.exchange.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangxu
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.blockchain.exchange.redis", "com.blockchain.exchange.gateway"})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
