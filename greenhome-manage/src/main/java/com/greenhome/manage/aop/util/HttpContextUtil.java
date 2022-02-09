package com.greenhome.manage.aop.util;


import com.google.gson.Gson;
import com.greenhome.common.constant.Constant;
import com.greenhome.common.log.DeviceInfo;
import eu.bitwalker.useragentutils.UserAgent;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author smart_joker
 * @Date 2022/2/8 5:24 下午
 * @Description 上下文对象实例
 * @Version 1.0
 */
@Component
public class HttpContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private static final String LOCAL_IP = Constant.DefaultValue.IP;

    public static String getDevice() {
        HttpServletRequest request = getHttpServletRequest();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader(Constant.HeadersKey.HEADER_USER_AGENT));
        String clientType = userAgent.getOperatingSystem().getDeviceType().toString();//客户端类型  手机、电脑、平板
        String os = userAgent.getOperatingSystem().getName();//操作系统类型
        String browser = userAgent.getBrowser().toString();//浏览器类型
        return new Gson().toJson(new DeviceInfo(clientType,os,browser));
    }

    public static String getIpAdder() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return Constant.DefaultValue.UNKNOWN;
        }
        String ip = request.getHeader(Constant.HeadersKey.HEADER_X_FORWARDED_FOR);
        if (StringUtil.isNullOrEmpty(ip) ||
                Constant.DefaultValue.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader( Constant.HeadersKey.HEADER_PROXY_IP);
        }
        if (StringUtil.isNullOrEmpty(ip) ||
                Constant.DefaultValue.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader( Constant.HeadersKey.HEADER_X_FORWARDED_FOR_UPPER);
        }
        if (StringUtil.isNullOrEmpty(ip) ||
                Constant.DefaultValue.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(Constant.HeadersKey.HEADER_WL_PROXY_IP);
        }
        if (StringUtil.isNullOrEmpty(ip) ||
                Constant.DefaultValue.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader( Constant.HeadersKey.HEADER_X_REAL_IP);
        }
        if (StringUtil.isNullOrEmpty(ip) ||
                Constant.DefaultValue.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return Constant.DefaultValue.IPV6.equals(ip) ? LOCAL_IP : ip;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取HttpServletRequest
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String getDomain() {
        HttpServletRequest request = getHttpServletRequest();
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String getOrigin() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader(Constant.HeadersKey.HEADER_ORIGIN);
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
