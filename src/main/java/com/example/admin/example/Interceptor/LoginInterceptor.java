package com.example.admin.example.Interceptor;

import org.springframework.amqp.rabbit.listener.adapter.HandlerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        HttpSession session = request.getSession();
        //得到session对象
        if(session == null){
            //没有登录成功，跳转到登录页面
            response.sendRedirect("/admin");
        }
        System.out.println(session);
        //取出会话数据
        String adminUsername = (String)session.getAttribute("adminUsername");
        System.out.println("----admin-login----");
        System.out.println(adminUsername);
        if(adminUsername == null){
            System.out.println("----admin-login1----");
            //没有登录成功，跳转到登录页面
            response.sendRedirect("/admin");
        }
        System.out.println("----admin-login2----");
        return true;
    }

}
