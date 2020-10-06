package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/admin")
    public String index(ModelMap map)
    {
        System.out.println("admin ----");
        map.addAttribute("name", "筱进GG");
        return "index";
    }
}
