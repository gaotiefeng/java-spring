package com.example.service;

import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public int userServiceAdd(String name, String mobile) {

        int count = 0;
        List list = userDao.userMobile(mobile);
        if(list!=null && !list.isEmpty()){
            return count;
        }
        count = userDao.userAdd(name, mobile);
        System.out.println("add方法被执行完毕");
        return  count;
    }
}
