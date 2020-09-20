package com.blockchain.exchange.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author zhangxu
 * @date 2020/8/30 13:32
 * @description
 */
@Configuration
public class RedisRateLimiterConfig {

    /**
     * 获取请求地址的uri作为限流key。
     */
    @Bean
    public KeyResolver uriKeyResolver() {
        //return exchange -> Mono.just(exchange.getRequest().getPath().value());
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());

    }
}
