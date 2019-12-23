package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String name, String mobile) {
        String sql = "insert into user(name, mobile) VALUES (?,?);";
        jdbcTemplate.update(sql, name, mobile);
        System.out.println("添加数据成功...");
    }
}
