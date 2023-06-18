package com.iflytek.collegespace.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 对于非静态资源，才需要进行处理
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        if (!(uri.contains("/bootstrap/") ||
                uri.contains("/css") ||
                uri.contains("/image") ||
                uri.contains("/js"))) {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
        }
        chain.doFilter(request, response);
    }
}
