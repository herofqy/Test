package com.example.demo.web.jeeWeb;

import javax.servlet.*;
import java.io.IOException;

public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(">>>>>> DemoFilter log ");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
