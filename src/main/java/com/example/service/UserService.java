package com.example.service;

import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int userServiceAdd(String name, String mobile) {
        int count = userDao.userAdd(name, mobile);
        System.out.println("add方法被执行完毕");
        return count;
    }
}
