package com.example.service.admin;

import com.example.dao.ArticleClassDao;
import com.example.model.ArticleClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleClassDao articleClassDao;

    public ArticleClassDao getArticleClassDao() {
        return articleClassDao;
    }

    //修改
    public int classSave(int id,int sort,String className)
    {
        ArticleClassModel articleClassModel = new ArticleClassModel();
        articleClassModel.setId(id);
        articleClassModel.setSort(sort);
        articleClassModel.setClassName(className);

        return this.articleClassDao.articleClassSave(articleClassModel);
    }
}
