package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
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
    public String register() {

        userService.add("mingzi","12435454545");
        return "3222323";
    }

    @RequestMapping(value = ("/list"), method = RequestMethod.GET)
    public HashMap list() {

        String[] data = {};

        return this.success(200,"list is success",data);
    }

}
