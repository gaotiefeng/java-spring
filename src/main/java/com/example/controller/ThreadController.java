package com.example.controller;

import com.example.thread.MessageThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("thread")
public class ThreadController {

    @RequestMapping(value = ("/create"), method = RequestMethod.GET)
    public String create(HttpServletRequest Request)
    {
        String number = Request.getParameter("number");

        Thread message = new MessageThread();
        message.start();

        System.out.println("main new thread!");

        return number;
    }
}
