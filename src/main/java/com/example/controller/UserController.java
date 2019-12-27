package com.example.controller;

import com.example.redis.StringRedis;
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

    private StringRedis stringRedis;

    /**
     *
     * @param Request
     * @return
     */
    @RequestMapping(value = ("/login"), method = RequestMethod.GET)
    public Map login(HttpServletRequest Request) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", "0");
        result.put("items",Request.getQueryString());

        return result;
    }

    /**
     *
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
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", "200");
        result.put("request",Request.getQueryString());
        result.put("message",message);

        return result;
    }

    @RequestMapping(value = ("/list"), method = RequestMethod.GET)
    @ResponseBody
    public Map list(HttpServletRequest Request, HttpServletResponse Response) {

        int id = Integer.parseInt(Request.getParameter("id"));

        Map list = userService.getUserDao().userFirst(id);

        String key = "id"+id;
        String val = "this is id "+id;

        //boolean redis = stringRedis.set(key,val);

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", "0");
        result.put("request",Request.getQueryString());
        result.put("items",list);

        return result;
    }

}
