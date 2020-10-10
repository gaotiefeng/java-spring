package com.example.admin.example.controller;

import com.example.admin.example.controller.BaseController;
import com.example.model.Admin;
import com.example.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController extends BaseController {

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
    @RequestMapping(value = ("/admin/login"),method = RequestMethod.POST)
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
        HttpSession session = Request.getSession();
        session.setAttribute("adminId",id);
        session.setAttribute("adminUsername",username);
        String sessionId = session.getId();
        session.setAttribute("sessionId",sessionId);
        session.setMaxInactiveInterval(60*60);

        return apiSuccess("登录成功",sessionId);
    }
    /**
     * 主页
     * @param map
     * @return
     */
    @RequestMapping("/admin/main")
    public String main(HttpServletRequest request,HttpServletResponse Response,ModelMap map)
    {
        map.addAttribute("name","this is main");
        return "index";
    }
}
