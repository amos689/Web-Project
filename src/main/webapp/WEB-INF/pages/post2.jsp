<%--
  Created by IntelliJ IDEA.
  User: Lei
  Date: 2023/5/6 0006
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>发表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">校园空间</a>
        </div>
        <label class="toggle-label visible-xs-inline-block" for="toggle-checkbox">MENU</label>
        <input class="hidden" id="toggle-checkbox" type="checkbox"/>
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

        </div>
    </div>
</div>

<div class="container">
    <div class="col-md-8 col-md-offset-2">
        <form action="${pageContext.request.contextPath}/post2" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title"><h3>标题</h3></label>
                <input type="text" name="title" class="form-control" id="title" placeholder="请输入标题"/>
            </div>
            <div class="form-group">
                <label for="cover"><h3>封面图片</h3></label>
                <input type="file" name="cover" class="form-control-file" id="cover"/>
            </div>
            <div class="form-group">
                <label for="content"><h3>内容</h3></label>
                <textarea name="content" class="form-control" id="content" rows="10"></textarea>
            </div>
            <div class="form-group">
                <label for="tags"><h3>标签</h3></label>
                <input type="text" name="tags" class="form-control" id="tags" placeholder="请输入标签，以逗号分隔"/>
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary" style="width: 50%">发布</button>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <address class="text-center">
        <p>关于博客园 | 联系我们 | 广告服务 | ©2004-2018博客</p>
        <div href="#">first.last@example.com</div>
    </address>
</div>
</body>
</html>

