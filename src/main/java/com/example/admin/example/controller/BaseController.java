package com.example.admin.example.controller;

import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public String salt = "abcdefghijklmnopqrstuvwxyz12345678910";
    /**
     * md5加密
     * @param password
     * @return
     */
    public String EncodeByMd5(String password) {
        String saltPassword=this.salt+"/"+password;
        String md5Password = DigestUtils.md5DigestAsHex(saltPassword.getBytes());
        return md5Password;
    }


    /* api 返回值 */
    public Map apiSuccess(String msg, Object data,int count)
    {
        int code = 0;

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);
        result.put("count",count);

        return result;
    }

    public Map apiSuccess(String msg, Object data)
    {
        int code = 0;

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);

        return result;
    }

    public Map apiSuccess(Integer code, String msg,Object data)
    {
        int count = 0;
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", code);
        result.put("msg",msg);
        result.put("data",data);
        result.put("count",count);

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
