package com.greenhome.manage.exception;

import cn.hutool.core.date.DateUtil;
import com.google.gson.Gson;
import com.greenhome.common.base.DefinitionException;
import com.greenhome.common.base.Result;
import com.greenhome.common.constant.Constant;
import com.greenhome.common.constant.GreenHomeEnum;
import com.greenhome.common.log.ExceptionSubject;
import com.greenhome.manage.aop.GlobalLogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author smart_joker
 * @Date 2022/2/10 4:48 下午
 * @Description 全局异常处理类(并打印日志)
 * @Version 1.0
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Result bizExceptionHandler(DefinitionException e) {
        return Result.defineError(e);
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        ExceptionSubject error = new ExceptionSubject();
        error.setDescription(e.getMessage());
        error.setLocationInfo(new Gson().toJson(e.getStackTrace()[0]));
        error.setTime(DateUtil.now());
        //logback设置ip地址
        MDC.put(Constant.DefaultKey.KEY_IP, GlobalLogAspect.ip);
        LOGGER.error(Constant.StringFormatType.LOG,new Gson().toJson(error));
        return Result.otherError(GreenHomeEnum.INTERNAL_SERVER_ERROR);
    }
}
