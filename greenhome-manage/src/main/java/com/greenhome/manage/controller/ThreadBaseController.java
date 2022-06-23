package com.greenhome.manage.controller;

import com.greenhome.service.inter.thread.ThreadBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutionException;

/**
 * @Author smart_joker
 * @Date 2022/6/22 4:40 下午
 * @Description 接口聚合获取
 * @Version 1.0
 */
@RestController
@Api(tags = "接口聚合获取测试")
@RequestMapping("/thread")
public class ThreadBaseController  {

    @Autowired
    public ThreadBaseService threadBaseService;

    @ApiOperation(value = "测试聚合接口开发", notes = "")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String doTest() throws ExecutionException, InterruptedException {
        return threadBaseService.doTest();
    }
}
