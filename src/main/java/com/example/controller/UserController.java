package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     *
     * @param Request
     * @return
     */
    @RequestMapping(value = ("/login"), method = RequestMethod.GET)
    public HashMap login(HttpServletRequest Request) {

        HashMap<String, Object> result = new HashMap<String, Object>();

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
    public HashMap register(HttpServletRequest Request, HttpServletResponse Response) {

        String name = Request.getParameter("name");
        String mobile = Request.getParameter("mobile");

        int count = userService.userServiceAdd(name,mobile);

        String message = "注册失败";
        if(count > 0) {
            message = "注册成功";
        }
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", "200");
        result.put("request",Request.getQueryString());
        result.put("message",message);

        return result;
    }

    @RequestMapping(value = ("/list"), method = RequestMethod.GET)
    @ResponseBody
    public HashMap list(HttpServletRequest Request, HttpServletResponse Response) {

        int id = Integer.parseInt(Request.getParameter("id"));

        Map list = userService.getUserDao().userFirst(id);

        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        HashMap<String, Object> result = new HashMap<String, Object>();

        result.put("code", "0");
        result.put("request",Request.getQueryString());
        result.put("items",ns);
        result.put("list",list);

        return result;
    }

}
