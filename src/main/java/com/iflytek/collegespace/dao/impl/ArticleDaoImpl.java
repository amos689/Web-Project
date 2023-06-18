package com.iflytek.collegespace.dao.impl;

import com.iflytek.collegespace.dao.ArticleDao;
import com.iflytek.collegespace.entity.Article;
import com.iflytek.collegespace.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

    @Override
    public int addArticle(Article article) {
        String sql = "INSERT INTO article(title,content,userid,posttime,category,tags,cover) " +
                "VALUE(?,?,?,?,?,?,?)";
        try {
            return runner.update(sql, article.getTitle(), article.getContent(),article.getUserid(),
                    article.getPosttime(), article.getCategory(), article.getTags(),article.getCover());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteArticle(int id) {
        String sql = "DELETE FROM article WHERE id=?";
        try {
            return runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateArticle(Article article) {
        String sql = "UPDATE article SET title=?,content=?,userid=?,posttime=?,category=?,tags=?" +
                " WHERE id=?";
        try {
            return runner.update(sql, article.getTitle(), article.getContent(),article.getUserid(),
                    article.getPosttime(), article.getCategory(), article.getTags(), article.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Article> getArticle(Article article) {
        String sql = "SELECT * FROM article WHERE 1=1"; // 1=1是无效条件, 但是可以为字符串拼接起到帮助
        List<Object> params = new ArrayList<>();
        // 根据查询参数拼接SQL语句
        if (article != null) {
            if (article.getId() != 0) {
                sql += " AND id=?";
                params.add(article.getId());
            }
            if (article.getTitle() != null && article.getTitle().length() > 0) {
                sql += " AND title LIKE %?%";
                params.add(article.getTitle());
            }
            if (article.getContent() != null && article.getContent().length() > 0) {
                sql += " AND content LIKE %?%";
                params.add(article.getContent());
            }
            if (article.getUserid() != 0) {
                sql += " AND userid=?";
                params.add(article.getUserid());
            }
            // 其他查询条件可以仿照上面续写，也可以根据实际支持的查询条件来调整
        }
        try {
            return runner.query(sql, new BeanListHandler<>(Article.class), params.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
