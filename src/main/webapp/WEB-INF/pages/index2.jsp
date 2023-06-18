<%--
  Created by IntelliJ IDEA.
  User: Lei
  Date: 2023/5/6 0006
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">校园空间</a>
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
                <c:choose>
                    <c:when test="${loginuser != null}">
                        <li><a href="#">欢迎您：${loginuser.nickname}</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
                        <li><a href="${pageContext.request.contextPath}/post">发布</a></li>
                        <li><a href="${pageContext.request.contextPath}/post2">发布2（带封面）</a></li>
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
        <div class="col-md-12">
            <div class="blog-list">
                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>#</th><th>标题</th><th>作者</th><th>分类</th><th>发布时间</th><th class="text-center">操作</th>
                    </tr>
                    <c:forEach items="${list}" var="article" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/article?id=${article.id}">${article.title}</a>
                        </td>
                        <td>${article.userid}</td>
                        <td>${article.category}</td>
                        <td>${article.posttime}</td>
                        <td class="text-center">
                            <c:if test="${loginuser.id == article.userid}">
                            <button class="btn btn-warning btn-xs" onclick="modifyArticle(${article.id})">编辑</button>
                            <button class="btn btn-danger btn-xs" onclick="deleteArticle(${article.id})">删除</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </div>
</div>
<div class="modal-footer">
    <address class="text-center">
        <p>关于Amos_鳳 | 广告招租 | ©自由的♂博客</p>
        <div href="#">Deep dark fantasy@door.com</div>
    </address>
</div>
<script>
    function modifyArticle(id){
        location.href = "${pageContext.request.contextPath}/modify?id=" + id;
    }

    function deleteArticle(id) {
        if (confirm("确定要删除该篇文章吗？")){
            location.href = "${pageContext.request.contextPath}/delete?id=" + id;
        }
    }
</script>
</body>
</html>
