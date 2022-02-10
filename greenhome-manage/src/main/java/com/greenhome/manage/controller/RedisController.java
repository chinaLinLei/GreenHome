package com.greenhome.manage.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "Redis测试接口")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value="设置redis的key-value值", notes="key和value都是字符串类型，仅测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "键", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "value", value = "值", required = true, dataType = "String", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功" ),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/string/set")
    public Object set(String key, String value){
        redisTemplate.opsForValue().set(key,value);
        return "success";
    }

    @ApiOperation(value="获取redis的key-value值", notes="key为字符串类型，仅测试")
    @ApiImplicitParam(name = "key", value = "键", required = true, dataType = "String", paramType = "query")
    @GetMapping("/string/get")
    public Object get(String key){
        return  redisTemplate.opsForValue().get(key);
    }

}
