package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController extends BaseController{

    public LoginController(){
        System.out.println("构造方法");
    }

    /**
     * 登录页面
     * @param map
     * @return
     */
    @RequestMapping("/admin")
    public String index(ModelMap map)
    {
        map.addAttribute("name", "变量传值");
        return "login/index";
    }
    /**
     * 登录验证
     * @return
     */
    @RequestMapping(value = ("/admin-login"),method = RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest Request)
    {
        String username = Request.getParameter("username");
        String password = Request.getParameter("password");
        System.out.println(username+password);

        return apiSuccess("登录成功",true);
    }
    /**
     * 主页
     * @param map
     * @return
     */
    @RequestMapping("/admin-main")
    public String main(ModelMap map)
    {
        map.addAttribute("name","this is main");
        return "index";
    }
}
