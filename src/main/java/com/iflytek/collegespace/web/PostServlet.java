package com.iflytek.collegespace.web;

import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PostServlet", value = "/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1、得知道输入了什么内容
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String tags = request.getParameter("tags");

        // 2、将数据封装到业务对象
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setTags(tags);
        User user = (User) request.getSession().getAttribute("loginuser");
        article.setUserid(user.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setPosttime(sdf.format(new Date()));

        // 3、调用业务进行插入操作
        ArticleService service = new ArticleServiceImpl();
        service.addArticle(article);

        // 4、继续跳页面：根据选择去跳
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
