package com.iflytek.collegespace.dao;

import com.iflytek.collegespace.entity.Article;

import java.util.List;

public interface ArticleDao {
    int addArticle(Article article);
    int deleteArticle(int id);
    int updateArticle(Article article);
    List<Article> getArticle(Article article);
}
