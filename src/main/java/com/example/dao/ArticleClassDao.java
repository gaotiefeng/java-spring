package com.example.dao;

import com.example.model.AdminModel;
import com.example.model.ArticleClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArticleClassDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArticleClassModel articleClassFirst(int id)
    {
        String sql = "select * from article_class where id = ?;";
        final ArticleClassModel articleClass = new ArticleClassModel();
        try {
            jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    articleClass.setId(resultSet.getInt("id"));
                    articleClass.setClassName(resultSet.getString("class_name"));
                    articleClass.setPid(resultSet.getInt("pid"));
                    articleClass.setSort(resultSet.getInt("sort"));
                }
            });
            return articleClass;
        }catch (Exception e) {
            return null;
        }

    }
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
     * 文章分类总数
     * @return
     */
    public int articleClassCount()
    {
        return this.jdbcTemplate.queryForObject("select count(1) from article_class", Integer.class);
    }
}
