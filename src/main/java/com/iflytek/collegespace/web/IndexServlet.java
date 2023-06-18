package com.iflytek.collegespace.web;

import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 通过session获取当前登录的用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginuser");
        System.out.println("当前登录的用户是：" + user);

        // 获取数据==》通过业务service去查询数据
        ArticleService service = new ArticleServiceImpl();
        List<Article> list = service.getArticle(null);

        // 通过request域对象传递数据到jsp中
        request.setAttribute("list", list);

        // 转发到页面
        request.getRequestDispatcher("/WEB-INF/pages/index2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
