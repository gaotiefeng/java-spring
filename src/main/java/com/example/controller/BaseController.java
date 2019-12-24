package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class BaseController {

    public HashMap success(int code, String message, String[] data) {

        HashMap<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("data", data);
        result.put("message", message);

        return result;
    }
}
