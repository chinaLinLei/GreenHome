package com.greenhome.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author smart_joker
 * @Date 2022/2/8 11:08 上午
 * @Description redis 自动配置
 * @Version 1.0
 */

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        // 构建template
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(factory);
        // 设置key序列化方式为字符串
        template.setKeySerializer(new StringRedisSerializer());
        // 设置value序列化方式为JSON
        template.afterPropertiesSet();
        return template;
    }
}
