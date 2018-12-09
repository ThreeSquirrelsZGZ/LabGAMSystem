<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="resource/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="resource/bootstrap/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="resource/lib/jquery-3.1.1.js"></script>
    <script type="text/javascript"
            src="resource/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/wukong-ui.css">
    <link rel="stylesheet" href="resource/bootstrap/css/bootstrap-select.min.css">

</head>

<body>
<div class="row">
    <div class="col-lg-12">
        <ul class="breadcrumb wk-breadcrumb">
            <li>实验室督勤管理系统</li>
            <li>消息管理</li>
            <li>发件箱</li>
        </ul>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default  wk-panel">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>主题</th>
                    <th>收件人</th>
                    <th>发件时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${messageList}" var="message">
                    <tr>
                        <td>${message.title}</td>
                        <td>${message.receivername}</td>
                         
                        <td><fmt:formatDate value="${message.sendtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        <td><a href="<%=basePath%>message/deleteOutMessage.html?id=${message.id}">删除</a>&nbsp;&nbsp;&nbsp;
                        <a href="<%=basePath%>message/getMessage.html?id=${message.id}">查看详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>


<script>

</script>
</body>

</html>