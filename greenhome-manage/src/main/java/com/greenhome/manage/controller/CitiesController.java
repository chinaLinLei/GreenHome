package com.greenhome.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author smart_joker
 * @Date 2022/1/27 2:32 下午
 * @Description 城市控制器
 * @Version 1.0
 */
@RestController
public class CitiesController {

    @RequestMapping("/index")
    public String test(){
        return "abc";
    }
}
