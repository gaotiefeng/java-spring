package com.example.dao;

import com.example.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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

    public void userList(int offset, int limit)
    {

    }

    public int userAdd(String name, String mobile) {
        String sql = "insert into user(name, mobile) VALUES (?,?);";
        int count = jdbcTemplate.update(sql, name, mobile);
        System.out.println("添加数据成功..."+count);
        return count;
    }


}
