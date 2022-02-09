package com.greenhome.manage.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author smart_joker
 * @Date 2022/2/8 4:42 下午
 * @Description 通知类型切片
 *
 * 前置通知（@Before）：在目标方法调用之前调用通知
 * 后置通知（@After）：在目标方法完成之后调用通知
 * 环绕通知（@Around）：在被通知的方法调用之前和调用之后执行自定义的方法
 * 返回通知（@AfterReturning）：在目标方法成功执行之后调用通知
 * 异常通知（@AfterThrowing）：在目标方法抛出异常之后调用通知
 *
 * @Version 1.0
 */
@Aspect
@Component
public class AopAdvice {
    @Pointcut("execution (* com.greenhome.manage.controller.*.*(..))")
    public void advice() {

    }

    @Before("advice()")
    public void beforeAdvice() {
        //todo
    }

    @After("advice()")
    public void afterAdvice() {
        //todo
    }

}
