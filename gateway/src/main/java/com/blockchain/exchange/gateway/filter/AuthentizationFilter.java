package com.blockchain.exchange.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhangxu
 * @date 2020/8/8 18:39
 * @descripti on
 */
@Slf4j
@Component
public class AuthentizationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestPath = request.getPath().value();
        log.info("AuthentizationFilter requestPath:{}", requestPath);
        String authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
