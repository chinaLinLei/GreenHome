package com.greenhome.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author smart_joker
 * @Date 2022/2/8 11:14 上午
 * @Description redis的测试类
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/redis/")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/string/set/{key}/{value}")
    public Object set(@PathVariable String key,@PathVariable String value){
        redisTemplate.opsForValue().set(key,value);
        return "success";
    }

    @GetMapping("/string/get/{key}")
    public Object get(@PathVariable String key){
        return  redisTemplate.opsForValue().get(key);
    }

}
