package com.iflytek.collegespace.web.filter;

import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String uri = req.getRequestURI(); // 获取当前请求的目标
        if (uri.contains("/post")){
            // 检测是否登录了
            User user = (User) req.getSession().getAttribute("loginuser");
            if (user == null){
                resp.sendRedirect(req.getContextPath()+"/login");
                return;
            }
        }

        if (uri.contains("/modify") || uri.contains("/delete")){
            // 首先需要判断是否登录
            User user = (User) req.getSession().getAttribute("loginuser");
            if (user == null){
                resp.sendRedirect(req.getContextPath()+"/login");
                return;
            }

            // 如果登录了，还需要判断登录的用户id==当前文章的作者id
            // req.getParameter("id") ==>查询文章对象==》作者id
            int id = Integer.parseInt(req.getParameter("id"));
            Article param = new Article();
            param.setId(id);
            ArticleService service = new ArticleServiceImpl();
            if (service.getArticle(param).get(0).getUserid() != user.getId()){
                resp.sendRedirect(req.getContextPath()+"/index");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
