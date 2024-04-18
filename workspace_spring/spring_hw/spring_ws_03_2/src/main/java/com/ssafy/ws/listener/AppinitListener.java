package com.ssafy.ws.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppinitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        application.setAttribute("root", application.getContextPath());
        System.out.println("listener init......");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
