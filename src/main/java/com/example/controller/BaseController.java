package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    public Map Success(String msg,Object data)
    {
        int code = 200;
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map Success(Integer code, String msg,Object data)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map Error(String msg,Object data)
    {
        int code = 500;
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map Error(Integer code, String msg,Object data)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }
}
