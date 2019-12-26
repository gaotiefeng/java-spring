package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map userFirst(int id)
    {
        String sql = "select * from user where id = ?;";
        Map list = jdbcTemplate.queryForMap(sql,id);
        return list;
    }

    public void userList()
    {

    }

    public int userAdd(String name, String mobile) {
        String sql = "insert into user(name, mobile) VALUES (?,?);";
        int count = jdbcTemplate.update(sql, name, mobile);
        System.out.println("添加数据成功..."+count);
        return count;
    }


}
