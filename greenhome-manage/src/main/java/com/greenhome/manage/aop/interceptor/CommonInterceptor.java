package com.greenhome.manage.aop.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author smart_joker
 * @Date 2022/6/27 3:33 下午
 * @Description 通用拦截器 针对action拦截
 * 动态拦截 action 调用的对象，然后提供了可以在 action 执行前后增加一些操作。常见场景如登录认证，
 * 通过拦截器验证用户的登录状态，若没有登录就会返回一个友好提示；记录日志，记录请求ip、方法执行时间等
 * @Version 1.0
 */

public class CommonInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(" 拦截器 request请求地址path[{}]  uri[{}]", request.getServletPath(),request.getRequestURI());
        try {
            //判断是否登录
            boolean verifyPermissions = verifyPermissions(request);
            //判断是否有权限
            boolean competence = competence(request);
            if (verifyPermissions && competence) {
                request.setAttribute("requestTime", System.currentTimeMillis());
                return true;
            }
            //这里设置拦截以后重定向的页面，一般设置为登陆页面地址
            response.sendRedirect(request.getContextPath() + "/error.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    private boolean competence(HttpServletRequest request) {
        return true;
    }

    private boolean verifyPermissions(HttpServletRequest request) {
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        if (!request.getRequestURI().contains("/online") && request.getSession(false) != null) {
            HttpSession session = request.getSession();
            String sessionName = (String) session.getAttribute("name");
            if ("caocao".equals(sessionName)) {
                logger.info("当前浏览器存在 session:{}",sessionName);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        long duration = System.currentTimeMillis() - Long.parseLong(request.getAttribute("requestTime").toString());
        logger.info("进入拦截器的请求地址是：{}，耗时:{}ms",request.getRequestURI(), duration);
    }
}
