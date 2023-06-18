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

@WebServlet(name = "ModifyServlet", value = "/modify")
public class ModifyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先要获取编辑的是谁
        // 将原始数据转发到JSP页面去显示

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
        request.getRequestDispatcher("/WEB-INF/pages/modify.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 1、得知道输入了什么内容==>修改后的
        String sid =request.getParameter("id");
        int id = Integer.parseInt(sid);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String tags = request.getParameter("tags");

        // 2、将数据封装到业务对象
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setTags(tags);
        User user = (User) request.getSession().getAttribute("loginuser");
        article.setUserid(user.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setPosttime(sdf.format(new Date()));

        System.out.println(article);

        // 3、调用业务进行修改操作
        ArticleService service = new ArticleServiceImpl();
        service.updateArticle(article);

        // 4、继续跳页面：根据选择去跳
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
