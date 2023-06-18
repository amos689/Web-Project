<%--
  Created by IntelliJ IDEA.
  User: Lei
  Date: 2023/5/8 0008
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html">My Blog</a>
        </div>
        <label class="toggle-label visible-xs-inline-block" for="toggle-checkbox">MENU</label>
        <input class="hidden" id="toggle-checkbox" type="checkbox">
        <div class="hidden-xs">
            <div class="col-sm-offset-2">
                <ul class="nav navbar-nav navbar-list">
                    <li><a href="#">全部分类</a></li>
                    <li><a href="#">语言</a></li>
                    <li><a href="#">数据结构</a></li>
                    <li><a href="#">网络</a></li>
                    <li><a href="#">操作系统</a></li>
                    <li><a href="#">算法</a></li>
                    <li><a href="#">实战</a></li>
                </ul>
            </div>
            <ul class="nav navbar-nav navbar-right">
<%--                如果登录了，则显示欢迎信息、退出、发布，否则，显示登录、注册--%>
                <c:choose>
                    <c:when test="${loginuser != null}">
                        <li><a href="#">欢迎您：${loginuser.nickname}</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
                        <li><a href="${pageContext.request.contextPath}/post">发布</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">登录</a></li>
                        <li><a href="${pageContext.request.contextPath}/regist">注册</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>


        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-2 hidden-xs">
            <div class="list-group side-bar">
                <a class="list-group-item active" role="button">随笔</a>
                <a class="list-group-item" role="button">随笔</a>
                <a class="list-group-item" role="button">随笔</a>
                <a class="list-group-item" role="button">随笔</a>
                <a class="list-group-item" role="button">随笔</a>
                <a class="list-group-item" role="button">随笔</a>
            </div>
        </div>

        <div class="col-sm-7">
            <div class="blog-list">
                <c:forEach items="${list}" var="article">
                <div class="blog-list-item clearfix">
                    <div class="col-xs-5">
                        <img src="../../image/bg1.jpg">
                    </div>
                    <div class="col-xs-7">
                        <a href="${pageContext.request.contextPath}/article?id=${article.id}" class="title">
                            ${article.title}
                        </a>
                        <div class="info">
                            <span class="avatar"><img src="../../image/v2-2d45613b0fb8cdd36f53c3b31d0c6ee8_hd.jpg"
                                                      alt="avatar"></span>
                            <span>${article.userid}</span> |
                            <span>热度</span>
                            <span class="glyphicon glyphicon-thumbs-up blog-hot" aria-hidden="true"></span> |
                            <span>${article.posttime}</span>
                        </div>
                        <div class="info">
                            <c:if test="${loginuser.id == article.userid}">
                            <a href="${pageContext.request.contextPath}/modify?id=${article.id}">修改</a>
                            <a href="javascript:void(0)" onclick="deleteArticle(${article.id})">删除</a>
                            </c:if>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

        <div class="col-sm-3 hidden-xs">
            <div class="search-bar">
                <form role="form">
                    <div class="form-group has-feedback">
                        <label class="sr-only" for="Search">Search：</label>
                        <input type="search" class="form-control" placeholder="搜索" id="Search">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </form>
            </div>
            <div class="side-bar-card clearfix">
                <div class="col-xs-5">
                    <img src="../../image/adver.png">
                </div>
                <div class="col-xs-7 side-bar-introduction">
                    <div class="">代码改变世界</div>
                    <div class="side-bar-phone">联系电话：XXXX</div>
                </div>
            </div>
            <div class="side-bar-card side-bar-recommend clearfix">
                <div class="side-bar-title">推荐阅读</div>
                <div class="side-bar-body">
                    <div class="side-bar-list">
                        <div class="side-bar-item">
                            <a href="blog.html" class="side-item-title">浅析Django项目优化</a>
                            <div class="side-item-info">10.4k阅读 | 五天前</div>
                        </div>
                        <div class="side-bar-item">
                            <a href="blog.html" class="side-item-title">python解释器</a>
                            <div class="side-item-info">0.4k阅读 | 一小时前</div>
                        </div>
                        <div class="side-bar-item">
                            <a href="blog.html" class="side-item-title">web前段优化策略</a>
                            <div class="side-item-info">2.9k阅读 | 一周前</div>
                        </div>
                        <div class="side-bar-item">
                            <a href="blog.html" class="side-item-title">浅析Django项目优化</a>
                            <div class="side-item-info">1.4k阅读 | 两小时前</div>
                        </div>
                        <div class="side-bar-item">
                            <a href="blog.html" class="side-item-title">浅析Django项目优化</a>
                            <div class="side-item-info">4.1k阅读 | 两天前</div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal-footer">
    <address class="text-center">
        <p>关于博客园 | 联系我们 | 广告服务 | ©2004-2018博客</p>
        <div href="#">first.last@example.com</div>
    </address>
</div>
<script>
    function deleteArticle(id){
        if (confirm("确定要删除该篇文章吗？")) {
            // 进来里面，说明点击了确定
            location.href="${pageContext.request.contextPath}/delete?id=" + id;
        }
    }
</script>
</body>
</html>
