package com.iflytek.collegespace.web;

import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.service.UserService;
import com.iflytek.collegespace.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 检查看看cookie有没有有效登录信息
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null){
//            for (Cookie cookie : cookies){
//                if (cookie.getName().equals("loginuser")){
//                    // 通过userService查询出用户对象，存到session中
//                    // 说明有登录的信息，不需要重复登录==》直接重定向到首页
//                    response.sendRedirect(request.getContextPath()+"index");
//                    return;
//                }
//            }
//        }

        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("doPost被调用了");
        // 从request获取用户提交的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + " password:" + password);

        // 调用服务进行登录的查询
        UserService service = new UserServiceImpl();
        User user = service.getUserByUsername(username);

        if (user == null) {
            System.out.println("用户不存在");
            request.setAttribute("errmsg", "用户名或密码输入错误，请重试");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            if (Objects.equals(user.getPassword(), password)) {
                System.out.println("登录成功");

                // 登录成功后，将登录用户存储到session域中
                HttpSession session = request.getSession();
                session.setAttribute("loginuser", user);

                // 登录成功后，将登录信息以Cookie发送回浏览器
                Cookie cookie = new Cookie("loginuser", user.getUsername());//1.创建
                cookie.setMaxAge(7*24*60*60);//2.设置有效期
                response.addCookie(cookie);//3.发送
                response.sendRedirect(request.getContextPath()+"index");
            } else {
                System.out.println("登录失败，密码输入错误！");
                request.setAttribute("errmsg", "用户名或密码输入错误，请重试");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }
        }
    }
}
