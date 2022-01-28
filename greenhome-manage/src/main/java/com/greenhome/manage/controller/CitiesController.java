package com.greenhome.manage.controller;

import com.greenhome.common.entity.CitiesEntity;
import com.greenhome.service.inter.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/1/27 2:32 下午
 * @Description 城市控制器
 * @Version 1.0
 */
@RestController
public class CitiesController {
    @Autowired
    public CitiesService citiesService;


    @RequestMapping("/index")
    public String test(){
        return "abc";
    }


    @RequestMapping("/select")
    public List<CitiesEntity> select(){
        return citiesService.selectAll();
    }
}
