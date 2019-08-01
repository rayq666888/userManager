package com.bjsxt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class EncodingFilter implements Filter {
    String encoding = "utf-8";
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置请求编码格式
        servletRequest.setCharacterEncoding(encoding);
        System.out.println("filerChain:"+filterChain);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("Encoding");
    }

}
