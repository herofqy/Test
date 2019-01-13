package com.example.demo.web.jeeWeb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DemoListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>>>DemoListener contextInitialized log");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">>>>>>DemoListener contextDestroyed log");
    }
}
