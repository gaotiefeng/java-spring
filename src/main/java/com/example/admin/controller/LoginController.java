package com.example.admin.controller;

import com.example.model.Admin;
import com.example.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends BaseController{

    @Autowired
    private AdminService adminService;

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
        String username = Request.getParameter("username").toString();
        String password = Request.getParameter("password");

        Admin admin = adminService.getAdminDao().adminUser(username);
        int id = admin.getId();
        if ("0".equals(String.valueOf(id)) || "null".equals(String.valueOf(id)) || id <= 0) {
            return apiError("用户不存在",true);
        }

        if (!EncodeByMd5(password).equals(admin.getPassword())) {
            return apiError("密码错误",true);
        }

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
