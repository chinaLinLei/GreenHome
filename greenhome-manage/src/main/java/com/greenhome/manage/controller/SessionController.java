package com.greenhome.manage.controller;

import com.greenhome.manage.aop.listener.CommonHttpSessionListener;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author smart_joker
 * @Date 2022/6/30 9:33 上午
 * @Description
 * @Version 1.0
 */

@RestController
@RequestMapping("/session")
@Api(tags = "Session和在线用户统计")
public class SessionController {

    @ApiOperation(value="设置session的key-value值", notes="key和value都是字符串类型，仅测试")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功" ),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/set")
    public Object set(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("name", "caocao");
        return "当前在线人数:" + session.getServletContext().getAttribute("sessionCount") + "人";
    }

    @ApiOperation(value="删除session的key值", notes="key是字符串类型，仅测试")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功" ),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/removeSession")
    public String removeSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "当前在线人数:" + session.getServletContext().getAttribute("sessionCount") + "人";
    }
    @ApiOperation(value="统计在线人数", notes="统计实时在线人数")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功" ),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/online")
    public String online() {
        return "当前在线人数:" + CommonHttpSessionListener.userCount.get() + "人";
    }
}
