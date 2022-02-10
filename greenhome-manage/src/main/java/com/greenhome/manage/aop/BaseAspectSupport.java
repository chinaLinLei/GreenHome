package com.greenhome.manage.aop;

import com.greenhome.common.base.DefinitionException;
import com.greenhome.common.constant.GreenHomeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

/**
 * @Author smart_joker
 * @Date 2022/2/8 5:00 下午
 * @Description 切面
 * @Version 1.0
 */
public class BaseAspectSupport {
    public Method resolveMethod(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?> targetClass = point.getTarget().getClass();
        Method method = getDeclaredMethod(targetClass, signature.getName(),
                signature.getMethod().getParameterTypes());
        if (method == null) {
            throw new DefinitionException(GreenHomeEnum.INTERNAL_SERVER_ERROR);
        }
        return method;
    }

    private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethod(superClass, name, parameterTypes);
            }
        }
        return null;
    }
}
