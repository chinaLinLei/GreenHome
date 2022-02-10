package com.greenhome.manage.aop;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.json.JSONUtil;
import com.greenhome.common.constant.Constant;
import com.greenhome.common.constant.EnvInfo;
import com.greenhome.common.log.LogSubject;
import com.greenhome.manage.aop.util.HttpContextUtil;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;


/**
 * @Author smart_joker
 * @Date 2022/2/8 4:49 下午
 * @Description 全局日志记录的切面类
 * <p>
 * 前置通知（@Before）：在目标方法调用之前调用通知
 * 后置通知（@After）：在目标方法完成之后调用通知
 * 环绕通知（@Around）：在被通知的方法调用之前和调用之后执行自定义的方法
 * 返回通知（@AfterReturning）：在目标方法成功执行之后调用通知
 * 异常通知（@AfterThrowing）：在目标方法抛出异常之后调用通知
 * @Version 1.0
 */

@Aspect
@Component
public class GlobalLogAspect extends BaseAspectSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalLogAspect.class);
    private static String ip = "";
    static {
        try {
            ip = getLocalIP();
        } catch (Exception e) {
            ip = Constant.DefaultValue.UNKNOWN;
        }
    }

    /**
     * 定义切面Pointcut
     */
    @Pointcut("execution(public * com.greenhome.manage.controller.*.*(..))")
    public void log() {

    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        LogSubject logSubject = new LogSubject();
        //记录时间定时器
        TimeInterval timer = DateUtil.timer(true);
        //执行结果
        Object result = joinPoint.proceed();
        logSubject.setResult(result);
        //执行消耗时间
        String endTime = timer.intervalPretty();
        logSubject.setSpendTime(endTime);
        //执行参数
        Method method = resolveMethod(joinPoint);
        logSubject.setParameter(getParameter(method, joinPoint.getArgs()));

        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        // 接口请求时间
        logSubject.setStartTime(DateUtil.now());
        //请求链接
        logSubject.setUrl(request.getRequestURL().toString());
        //请求方法GET,POST等
        logSubject.setMethod(request.getMethod());
        //请求设备信息
        logSubject.setDevice(HttpContextUtil.getDevice());
        //请求地址
        logSubject.setIp(HttpContextUtil.getIpAdder());
        //接口描述
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
            logSubject.setDescription(apiOperation.value());
        }

        //logback设置ip地址
        MDC.put(Constant.DefaultKey.KEY_IP, ip);
        LOGGER.info(Constant.StringFormatType.LOG, JSONUtil.toJsonPrettyStr(logSubject));
        return result;
    }


    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            String key = parameters[i].getName();
            if (requestBody != null) {
                argList.add(args[i]);
            } else if (requestParam != null) {
                map.put(key, args[i]);
            } else {
                map.put(key, args[i]);
            }
        }
        if (map.size() > 0) {
            argList.add(map);
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }

    public static String getLocalIP() throws Exception {
        String ip = "";
        if (System.getProperty(Constant.DefaultKey.KEY_OS_NAME).equalsIgnoreCase(Constant.OsType.WINDOWS)) {
            InetAddress adder = InetAddress.getLocalHost();
            ip = adder.getHostAddress();
            return ip;
        } else {
            Enumeration<?> e1 = (Enumeration<?>) NetworkInterface
                    .getNetworkInterfaces();
            while (e1.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e1.nextElement();
                if (!ni.getName().equals(EnvInfo.NETWORK_NAME)) {
                    continue;
                } else {
                    Enumeration<?> e2 = ni.getInetAddresses();
                    while (e2.hasMoreElements()) {
                        InetAddress ia = (InetAddress) e2.nextElement();
                        if (ia instanceof Inet6Address)
                            continue;
                        ip = ia.getHostAddress();
                        return ip;
                    }
                    break;
                }
            }
        }
        return "";
    }
}
