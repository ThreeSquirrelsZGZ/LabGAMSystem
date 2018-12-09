<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				 <li>实验室督勤管理系统</li>
	            <li>签到管理</li>
	            <li>签到数据录入</li>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default wk-panel ">
				<div class="panel-heading">签到数据录入</div>
				<form action="<%=basePath%>saveAttendance.html" method="POST">
					<div class="panel-body">
						<div class="row">
							<div class="form-inline">
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">选择时间:
									</label>
									<div class="input-group">
										<input required="required" name="recordDate" type="date"
											class="form-control wk-normal-input"
											placeholder="输入格式为:xxx-xx-xx" />
									</div>
									<!-- <div class="input-group">
										<select class="wk-select" name="recordDate">
											<option value="2018-04-01">2018-04-01</option>
											<option value="2018-04-01">2018-05-01</option>
											<option value="2018-04-01">2018-06-01</option>
											<option value="2018-04-01">2018-07-01</option>
											<option value="2018-04-01">2018-08-01</option>
											<option value="2018-04-01">2018-09-01</option>
											<option value="2018-04-01">2018-10-01</option>
											<option value="2018-04-01">2018-11-01</option>
											<option value="2018-04-01">2018-12-01</option>
											<option value="2018-04-01">2019-01-01</option>
											<option value="2018-04-01">2019-21-01</option>
											<option value="2018-04-01">2019-03-01</option>
											<option value="2018-04-01">2019-04-01</option>
											<option value="2018-04-01">2019-05-01</option>
											<option value="2018-04-01">2019-06-01</option>
											<option value="2018-04-01">2019-07-01</option>
										</select>
									</div> -->
								</div>
								
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">学生姓名:
									</label>
									<div class="input-group">
										<select class="wk-select" name="userId">
										<c:forEach items="${users}" var="var">
											<option value="${var.id}">${var.name}</option>
										</c:forEach>
									</select>
									</div>
								</div>

								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">应勤天数:
									</label>
									<div class="input-group">
										<input required="required" name="amount" type="number"
											class="form-control wk-normal-input"
											placeholder="请输入应出勤天数" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">请假天数:
									</label>
									<div class="input-group">
										<input required="required" name="leave" type="number"
											class="form-control wk-normal-input"
											placeholder="请输入请假天数" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">旷工天数:
									</label>
									<div class="input-group">
										<input required="required" name="absenteeism" type="number"
											class="form-control wk-normal-input"
											placeholder="请输入旷工天数" />
									</div>
								</div>
								
								<div class="form-group">
									<!-- <label for="filePath" class="control-label wk-filed-label">调休天数:
									</label>  -->
									<div class="input-group" style="display:none;">
										<input required="required" name="vacation" type="number"
											class="form-control wk-normal-input"
											placeholder="请输入调休天数" value="31" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">实际天数:
									</label>
									<div class="input-group">
										<input required="required" name="realAmount" type="number"
											class="form-control wk-normal-input"
											placeholder="请输入实际天数" />
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="panel-footer wk-panel-footer">
						<button type="submit" class="btn btn-default wk-btn">提&nbsp;&nbsp;交</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>