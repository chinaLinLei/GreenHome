package com.greenhome.manage.aop;

import com.google.gson.Gson;
import com.greenhome.common.base.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author smart_joker
 * @Date 2022/2/11 6:14 下午
 * @Description body体重写
 * @Version 1.0
 */

@RestControllerAdvice(basePackages = "com.greenhome.manage.controller")
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Result beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(o instanceof Result){
            return (Result)o;
        }
        return new Result(o);
    }
}
