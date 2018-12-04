<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script type="text/javascript" src="resource/bootstrap/js/bootstrap-select.min.js"></script>
</head>

<body>
	<div class="row">
		<div class="col-lg-12">
			<ul class="breadcrumb wk-breadcrumb">  
				 <li><a href="#">实验室督勤管理系统</a></li>
	            <li><a href="#">消息详情</a></li>
	            
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default wk-panel ">
				<div class="panel-heading">消息详情</div>
				
					<div class="panel-body">
						<div class="row " style="margin-left:30px">
							<div class="col-xs-2">
								主题：${message.title}
							</div>
							<div class=" col-xs-2" >
								收件人：${message.receivername}
							</div>
							<div class="col-xs-2" >
								发件人：${message.sendname}
							</div>
							<div class="col-xs-2" >
								发件时间：<fmt:formatDate value="${message.sendtime}" pattern="yyyy/MM/dd HH:mm:ss" />
							</div>
						</div>
						
							<div  class="row " style="margin-left:45px;margin-top:10px ">
							消息内容：
							</div>
							<div  class="row " style="margin-left:45px; ">
							${message.content}
							</div>
						<div class="row " style="margin-left:45px;margin-top:10px">
						<c:choose>
   							<c:when test="${message.filename!=null}">  
    						下载附件：
    						<a href="<%=basePath%>message/downloadFile.html?id=${message.id}">
    						
    							${message.filename}      
    						</a>
   							</c:when>
   
						</c:choose>
						</div>
					</div>

					
			</div>
		</div>
	</div>

</body>
</html>