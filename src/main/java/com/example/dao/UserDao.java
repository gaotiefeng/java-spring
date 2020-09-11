package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * id查询
     * @param id
     * @return
     */
    public Map userFirst(int id)
    {
        String sql = "select * from user where id = ?;";

        Map list = jdbcTemplate.queryForMap(sql,id);
        return list;
    }
    /**
     * 手机号查询数据
     * @param mobile
     * @return
     */
    public List userMobile(String mobile) {
        String sql = "select * from user where mobile = ?;";

        List list = jdbcTemplate.queryForList(sql, mobile);
        System.out.println(mobile + "查询..."+list);
        return list;
    }

    /**
     * 列表
     * @param offset
     * @param limit
     * @return
     */
    public List userList(int offset, int limit)
    {
        String sql = "select * from user where id >=( select id from user order by id limit ?,1 ) limit ?;";

        List list = jdbcTemplate.queryForList(sql, offset, limit);
        return list;
    }

    /**
     * 添加用户
     * @param name
     * @param mobile
     * @return
     */
    public int userAdd(String name, String mobile) {
        String sql = "insert into user(name, mobile) VALUES (?,?);";
        int count = jdbcTemplate.update(sql, name, mobile);
        System.out.println("添加数据成功..."+count);
        return count;
    }

    /**
     * 更新数据
     * @param id
     * @param name
     * @param email
     * @return
     */
    public int userSave(int id, String name, String email) {
        String sql = "update user set name = ?, email = ? where id = ?";
        int count = jdbcTemplate.update(sql, name,email,id);
        System.out.println("更新数据成功..."+count);
        return count;
    }

}
