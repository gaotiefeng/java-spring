package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleClassDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 分类列表
     * @param offset
     * @param limit
     * @return
     */
    public List articleClassList(int offset, int limit)
    {
        String sql = "select * from article_class where id >=( select id from article_class order by id limit ?,1 ) limit ?;";

        List list = jdbcTemplate.queryForList(sql, offset, limit);
        return list;
    }

    /**
     * 总数
     * @return
     */
    public int articleClassCount()
    {
        return this.jdbcTemplate.queryForObject("select count(1) from article_class", Integer.class);
    }
}
