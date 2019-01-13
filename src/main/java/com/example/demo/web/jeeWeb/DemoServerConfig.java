package com.example.demo.web.jeeWeb;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//注册原生三大组件
@Configuration
public class DemoServerConfig {

    //注册servlet,参考DispatcherServletAutoConfiguration
    @Bean
    public ServletRegistrationBean jeeWebDemoServlet(){
        return new ServletRegistrationBean(new DemoServlet(),"/jeeWebDemoServlet");
    }

    //注册filter
    @Bean
    public FilterRegistrationBean jeeWebDemoFilter(){
        return new FilterRegistrationBean(new DemoFilter(),jeeWebDemoServlet());
    }

    //注册listener
    @Bean
    public ServletListenerRegistrationBean jeeWebDemoListener(){
        return new ServletListenerRegistrationBean(new DemoListener());
    }
}
