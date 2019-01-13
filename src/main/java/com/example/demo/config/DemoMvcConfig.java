package com.example.demo.config;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通过java bean的方式配置SpringMvc,使用@EnableWebMvc将完全接管SpringMvc
 * 配置文件映射ServerProperties
 */
@Configuration
public class DemoMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //自定义添加视图和虚拟路由的连接
        registry.addViewController("index").setViewName("index.html");
    }

}
