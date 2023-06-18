package com.iflytek.collegespace.web;


import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "PostServlet", value = "/post2")
@MultipartConfig
public class Post2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/post2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginuser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int userid = loginUser.getId();
        String posttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String tags = request.getParameter("tags");
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setUserid(userid);
        article.setPosttime(posttime);
        article.setTags(tags);

        Part coverPart = request.getPart("cover");
        String fileName = coverPart.getSubmittedFileName();
        System.out.println("上传的文件名：" + fileName);
        String realPath = request.getServletContext().getRealPath("/covers"); // 获取webapp下指定目录的真实路径（绝对路径）
        System.out.println("存储封面的目录：" + realPath);
        /*
        检测目录是否存在
         */
        File pathFile = new File(realPath);
        if (!pathFile.exists() || !pathFile.isDirectory()) {
            pathFile.mkdirs(); // 不存在则创建
        }
        String dstFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        coverPart.write(realPath + "/" + dstFileName); // 保存文件到本地目录中
        article.setCover("/covers/" + dstFileName); // 存储相对与webapp的路径名称，在HTML中再拼接前面的web应用地址

        System.out.println(article);
        ArticleService service = new ArticleServiceImpl();
        int rlt = service.addArticle(article);
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
