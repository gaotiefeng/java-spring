package com.example.controller;

import com.example.redis.StringRedis;
import com.example.service.http.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private  StringRedis stringRedis;

    /**
     * 登录
     * @param Request
     * @return
     */
    @RequestMapping(value = ("/login"), method = RequestMethod.GET)
    public Map login(HttpServletRequest Request) {

        String mobile = Request.getParameter("mobile");
        if("0".equals(String.valueOf(mobile)) || "null".equals(String.valueOf(mobile))) {
            return Error("用户名不能为空",false);
        }
        List user = userService.getUserDao().userMobile(mobile);
        Object u = user.get(0);

        String password = Request.getParameter("password");
        

        return Success("登录成功",user);
    }

    /**
     *  注册
     * @return
     */
    @RequestMapping(value = ("/register"), method = RequestMethod.GET)
    @ResponseBody
    public Map register(HttpServletRequest Request, HttpServletResponse Response) {

        String name = Request.getParameter("name");
        String mobile = Request.getParameter("mobile");

        int count = userService.userServiceAdd(name,mobile);

        String message = "注册失败";
        if(count > 0) {
            message = "注册成功";
        }

        return Success(message,Request.getQueryString());
    }

    /**
     * 用户列表
     * @param Request
     * @param Response
     * @return
     */
    @RequestMapping(value = ("/list"), method = RequestMethod.GET)
    @ResponseBody
    public Map list(HttpServletRequest Request, HttpServletResponse Response) {


        int offset = Integer.parseInt(Request.getParameter("offset"));

        int limit = Integer.parseInt(Request.getParameter("limit"));
        //todo limit is empty
        List list = userService.getUserDao().userList(offset, limit);

        return Success("查询成功",list);
    }

    /**
     * 用户详情
     * @param Request
     * @return
     */
    @RequestMapping(value = ("/find"),method = RequestMethod.GET)
    @ResponseBody
    public Map findByUser(HttpServletRequest Request)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int id = Integer.parseInt(Request.getParameter("id"));

        if("0".equals(String.valueOf(id)) || "null".equals(String.valueOf(id)) || id <= 0) {
           return Error("id不能为空",false);
        }

        try {
            Client client = new Client();
            client.client();
        }catch (Exception e) {
            System.out.println(e);
            return Error("服务器繁忙",false);
        }

        Map list = userService.getUserDao().userFirst(id);

        return Success("查询成功",list);
    }

}
