package com.example.admin.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /* api 返回值 */
    public Map apiSuccess(String msg, Object data)
    {
        int code = 200;
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map apiSuccess(Integer code, String msg,Object data)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map apiError(String msg,Object data)
    {
        int code = 500;
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map apiError(Integer code, String msg,Object data)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }
}
