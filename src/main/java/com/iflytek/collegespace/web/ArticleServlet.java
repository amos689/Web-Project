package com.iflytek.collegespace.web;

import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ArticleServlet", value = "/article")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、要知道当前点击的是谁--》id
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);

        // 2、获取对应的文章对象
        ArticleService service = new ArticleServiceImpl();
        Article param = new Article(); // --》查询参数
        param.setId(id); // 设置要查询的参数
        Article article = service.getArticle(param).get(0);

        // 3、传递对象到JSP去显示
        request.setAttribute("article", article);
        request.getRequestDispatcher("/WEB-INF/pages/article.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
