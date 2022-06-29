package com.greenhome.manage.aop.filter;

import com.google.gson.Gson;
import com.greenhome.common.base.Result;
import com.greenhome.common.constant.GreenHomeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author smart_joker
 * @Date 2022/6/23 2:24 下午
 * @Description 基础拦截器，用于过滤掉一些不符合要求的请求
 * 常见场景如session校验、url校验，若不符合条件，则会被过滤掉做出特殊的响应。
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/*",filterName = "CommonFilter")
@Order(1) // filter顺序 越小越在前
public class CommonFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(CommonFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        logger.info("过滤器进入");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUri = request.getRequestURI();
        if (requestUri.contains("/manage/a")) {
            //返回
            PrintWriter writer = response.getWriter();
            writer.write(new Gson().toJson(Result.otherError(GreenHomeEnum.REQUEST_FILTER)));
            writer.flush();
            if (writer!=null){
                writer.close();
            }
        } else {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        logger.info("过滤器销毁");
    }
}
