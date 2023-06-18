package com.iflytek.collegespace.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;

@WebListener
public class TestListener implements ServletContextListener, ServletRequestListener {

    private static int count = 0;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("服务器启动时间：" + new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        count++;
        System.out.println("当前有人访问了web应用，统计总访问量：" + count);
    }
}
