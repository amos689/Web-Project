package com.iflytek.collegespace.service.impl;


import com.iflytek.collegespace.dao.ArticleDao;
import com.iflytek.collegespace.dao.impl.ArticleDaoImpl;
import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.service.ArticleService;
import com.iflytek.collegespace.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao dao = new ArticleDaoImpl();

    @Override
    public int addArticle(Article article) {
        return dao.addArticle(article);
    }

    @Override
    public int deleteArticle(int id) {
        return dao.deleteArticle(id);
    }

    @Override
    public int updateArticle(Article article) {
        return dao.updateArticle(article);
    }

    @Override
    public List<Article> getArticle(Article article) {
        return dao.getArticle(article);
    }
}
