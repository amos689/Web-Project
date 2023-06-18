package com.iflytek.collegespace.entity;

import java.util.Date;

/**
 * 文章类
 */
public class Article {
    private int id;             //文章ID
    private String title;      //文章标题
    private String content;    //正文内容
    private int userid;     //作者id
    private String posttime;  //发布时间
    private String category;   //分类
    private String tags;     //标签
    private String cover; // 封面图片

    //以下是各属性的getters和setters方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userid=" + userid +
                ", posttime='" + posttime + '\'' +
                ", category='" + category + '\'' +
                ", tags='" + tags + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
