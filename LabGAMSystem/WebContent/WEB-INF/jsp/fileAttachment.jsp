<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li><a href="#">实验室督勤管理系统</a></li>
            <li><a href="#">文件管理</a></li>
            <li><a href="#">文件管理</a></li>
        </ul>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default  wk-panel">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>文件名</th>
                    <th>上传时间</th>
                    <th>上传者</th>
                    <th>下载次数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${fileList}" var="file">
                    <tr>
                        <td>${file.id}</td>
                        <td>${file.name}</td>
                        <td>${file.uploadTime}</td>
                        <td>${file.userId}</td>
                        <td>${file.downLoadCount}</td>
                        <td><a href="<%=basePath%>file/downloadFile/${file.id}.html">下载</a>
                        &nbsp; &nbsp;
                        <c:choose>
   							<c:when test="${user.roleId==0}">  
    							<a href="<%=basePath%>file/deleteFile.html?id=${file.id}">删除</a>
   							</c:when>
   
						</c:choose>
                        
                        
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog"
     id="deleteConfirm">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header wk-modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4>系统提示</h4>
            </div>
            <div class="modal-body">您确定要删除这些记录？</div>
            <div class="modal-footer wk-modal-footer">
                <button id="deleteBtnOK" type="submit"
                        class="btn btn-default wk-btn" data-dismiss="modal">确定
                </button>
                <button type="button" class="btn btn-default wk-tool-btn"
                        data-dismiss="modal">取消
                </button>
            </div>
        </div>
    </div>
</div>

<script>

</script>
</body>

</html>