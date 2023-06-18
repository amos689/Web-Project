package com.iflytek.collegespace.web;

import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 1、要知道当前点击的是谁--》id
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);

        // 调用业务进行删除
        ArticleService service = new ArticleServiceImpl();
        service.deleteArticle(id);

        // 跳回到首页
        response.sendRedirect(request.getContextPath() + "/index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
