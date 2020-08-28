package com.blockchain.exchange.gateway.dao;

import com.blockchain.exchange.redis.constants.CommonConstant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxu
 * @date 2020/8/15 18:50
 * @description
 */
@Component
@ConditionalOnClass(RedisTemplate.class)
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisRouteDefinitionRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        redisTemplate.opsForHash().entries(CommonConstant.GATEWAY_ROUTEKEY).values().stream().forEach(o -> {
            routeDefinitions.add((RouteDefinition) o);
        });
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(r -> {
            if (StringUtils.isEmpty(r.getId())) {
                return Mono.error(new IllegalArgumentException("id may not be empty"));
            }
            redisTemplate.opsForHash().put(CommonConstant.GATEWAY_ROUTEKEY, r.getId(), r);
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            if (redisTemplate.opsForHash().hasKey(CommonConstant.GATEWAY_ROUTEKEY, id)) {
                redisTemplate.opsForHash().delete(CommonConstant.GATEWAY_ROUTEKEY, id);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(
                    new NotFoundException("RouteDefinition not found: " + routeId)));
        });
    }
}
