package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List userMobile(String mobile) {
        String sql = "select * from user where mobile = ?;";
        List list = jdbcTemplate.queryForList(sql, mobile);
        System.out.println(mobile + "查询..."+list);
        return list;
    }

    public Map userFirst(int id)
    {
        String sql = "select * from user where id = ?;";
        Map list = jdbcTemplate.queryForMap(sql,id);
        return list;
    }

    public List userList(int offset, int limit)
    {
        String sql = "select * from user where offset = ? and limit = ?;";
        List list = jdbcTemplate.queryForList(sql, offset, limit);
        return list;
    }

    public int userAdd(String name, String mobile) {
        String sql = "insert into user(name, mobile) VALUES (?,?);";
        int count = jdbcTemplate.update(sql, name, mobile);
        System.out.println("添加数据成功..."+count);
        return count;
    }


}
