package com.example.dao;

import com.example.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * admin 用户查询数据
     * @param username
     * @return
     */
    public Admin adminUser(String username) {
        String sql = "select * from admin where username = ?;";
        final Admin admin = new Admin();
        jdbcTemplate.query(sql, new Object[]{username},new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                admin.setId(resultSet.getInt("id"));
                admin.setUsername(username);
                admin.setPassword(resultSet.getString("password"));
            }
        });
        System.out.println(username + "查询..."+admin);
        return admin;
    }
}
