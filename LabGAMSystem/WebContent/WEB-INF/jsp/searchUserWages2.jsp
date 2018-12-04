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
            <li><a href="#">补贴管理</a></li>
            <li><a href="#">学生补贴查询</a></li>
        </ul>
		</div>
	</div>
<!-- 
	<div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default wk-panel wk-table-tools-panel">
                <div class="panel-heading">
                    工具栏 Tools
                </div>
                <div class="panel-body">
	                <button id="updateBtn" type="button" class="btn btn-default wk-tool-btn">修改薪资</button>
                 </div>
            </div>
        </div>
    </div> -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default  wk-panel">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<!--  <th>选择</th>-->
							<th>学生编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>所属课题组</th>
							<th>当前补贴</th>
							<th>联系电话</th>
							<th>联系地址</th>
							<th>身份证号</th>
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
						</tr>
						
					</tbody>
					
				</table>
			</div>
		</div>
	</div>

	<div class="modal fade" tabindex="-1" role="dialog"
		id="updateConfirm">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header wk-modal-header">
					<button class="close" type="button" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4>系统提示</h4>
				</div>
				<form id="wagesForm" method="POST">
				<div class="modal-body">
					<div class="form-inline">
						<div class="form-group">
                                <label  class="control-label wk-filed-label">补贴: </label>
                                <div class="input-group">
                                    <input required="required" id="wages" name="wages" type="number" class="form-control wk-normal-input" id="mark" placeholder="请输入薪资水平"/>
                                </div>
                         </div>
					</div>
				</div>
				<div class="modal-footer wk-modal-footer">
					<button id="updateBtnOK" type="submit"
						class="btn btn-default wk-btn" data-dismiss="modal">确定</button>
					<button type="button" class="btn btn-default wk-tool-btn"
						data-dismiss="modal">取消</button>
				</div>
				</form>
			</div>
		</div>
	</div>

	<script>
     $("#updateBtn").on("click", function() {
        var id = "";
        $(":radio").each(function() {
            if ($(this).is(":checked")) {
                id = $(this).attr("id").substr(5, $(this).attr("id").length);
            }
        });         

        if (id != "") {
        	$("#wages").val($("#grid_" + id).attr("role"));
        	$("#updateConfirm").modal();
        	
        	$("#updateBtnOK").on("click", function() {
        		$("#wagesForm").attr("action", "<%=basePath%>updateUserWages/" + id + ".html");
        		$("#wagesForm").submit();
        	});
        }
    });

     
</script>
</body>
</html>