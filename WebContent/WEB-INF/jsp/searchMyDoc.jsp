<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="bootstrap/css/bootstrap-select.min.css">
<script type="text/javascript"
	src="bootstrap/js/bootstrap-select.min.js"></script>
</head>

<body>
	<div class="row">
		<div class="col-lg-12">
			<ul class="breadcrumb wk-breadcrumb">
            <li><a href="#">实验室督勤管理系统</a></li>
            <li><a href="#">档案管理</a></li>
            <li><a href="#">学生档案查询</a></li>
        </ul>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default  wk-panel">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>学生编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>所属课题组</th>
							<th>当前补贴</th>
							<th>联系电话</th>
							<th>联系地址</th>
							<th>身份证号</th>
							<th>民族</th>
							<th>学历</th>
							<th>毕业院校</th>
							<th>所学专业</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>${user.number}</th>
							<th>${user.name}</th>
							<th>${user.genderName}</th>
							<th>${user.deptName}</th>
							<th>${user.wages}</th>
							<th>${user.telphone}</th>
							<th>${user.address}</th>
							<th>${user.idCardNo}</th>
							<th>${user.nationalName}</th>
							<th>${user.educationName}</th>
							<th>${user.institute}</th>
							<th>${user.major}</th>
						</tr>
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
						class="btn btn-default wk-btn" data-dismiss="modal">确定</button>
					<button type="button" class="btn btn-default wk-tool-btn"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<script>

    $("#deleteBtn").on("click", function() {
        var id = "";
        $(":radio").each(function() {
            if ($(this).is(":checked")) {
                id = $(this).attr("id").substr(5, $(this).attr("id").length);
            }
        });

        if (id != "") {
            $("#deleteConfirm").modal();
            $("#deleteBtnOK").on("click", function() {
                location.href = "<%=basePath%>deleteUser/" + id + ".html";
            });
        }
    });

    

     $("#updateBtn").on("click", function() {
        var id = "";
        $(":radio").each(function() {
            if ($(this).is(":checked")) {
                id = $(this).attr("id").substr(5, $(this).attr("id").length);
            }
        });         

        if (id != "") {
			location.href = "<%=basePath%>updateUser/" + id + ".html";
        }
    });

     
</script>
</body>
</html>