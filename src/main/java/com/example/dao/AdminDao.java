package com.example.dao;

import com.example.model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AdminDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * admin 用户查询数据
     * @param username
     * @return
     */
    public AdminModel adminUser(String username) {
        String sql = "select * from admin where username = ?;";
        final AdminModel admin = new AdminModel();
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
