package com.example.service.admin;

import com.example.dao.ArticleClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleClassDao articleClassDao;

    public ArticleClassDao getArticleClassDao() {
        return articleClassDao;
    }
}
