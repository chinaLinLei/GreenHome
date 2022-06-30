package com.greenhome.manage.aop.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author smart_joker
 * @Date 2022/6/29 4:50 下午
 * @Description 实现监听器
 * @Version 1.0
 */

public class CommonHttpSessionListener implements HttpSessionListener {
    private final Logger logger = LoggerFactory.getLogger(CommonHttpSessionListener.class);
    public static AtomicInteger userCount = new AtomicInteger(0);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        userCount.getAndIncrement();
        se.getSession().getServletContext().setAttribute("sessionCount", userCount.get());
        logger.info("在线人数人数增加为:{}",userCount.get());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userCount.getAndDecrement();
        se.getSession().getServletContext().setAttribute("sessionCount", userCount.get());
        logger.info("在线人数人数减少为:{}",userCount.get());
    }
}
