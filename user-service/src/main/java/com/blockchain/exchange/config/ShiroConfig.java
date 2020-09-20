package com.blockchain.exchange.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxu
 * @date 2020/8/29 07:57
 * @description
 */
@Configuration
public class ShiroConfig {
    @Bean
    public DefaultSecurityManager securityManager(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        return defaultSecurityManager;
    }
}
