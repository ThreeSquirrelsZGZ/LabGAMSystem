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
<script type="text/javascript">
	window.onload=function()
	{
		document.getElementById('receiver').addEventListener('change',function(){
                 var  myselect=document.getElementById("receiver");
                 var index=myselect.selectedIndex ;   
                 var receiverid=document.getElementById('receiverid');
                 var receivername=document.getElementById('receivername');
                 if(receiverid.value!='')
                 {
                 	receiverid.value=receiverid.value+","+this.value;
                 	receivername.value=receivername.value+","+myselect.options[index].text;
                 }else
                 {
                 	receiverid.value=this.value;
                 	receivername.value=myselect.options[index].text;
                 }
                 
             },false);
	
	}
	
</script>

</head>

<body>
	<div class="row">
		<div class="col-lg-12">
			<ul class="breadcrumb wk-breadcrumb">  
				 <li><a href="#">实验室督勤管理系统</a></li>
	            <li><a href="#">消息管理</a></li>
	            <li><a href="#">发送消息</a></li>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default wk-panel ">
				<div class="panel-heading">录入消息信息</div>
				<form action="<%=basePath%>message/saveMessage.html" enctype="multipart/form-data" method="POST">
					<div class="panel-body">
						<div class="row">
							<div class="form-inline">
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">主题:
									</label>
									<div class="input-group">
										<input required="required" name="title" type="text"
											class="form-control wk-normal-input"
											placeholder="请输入消息主题" />
									</div>
								</div>
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">收件人:
									</label>
									<div class="input-group">
										<input name="receiverid" style="display:none" id="receiverid"/>
										<input   type="text" id="receivername"
											class="form-control wk-normal-input"
											placeholder="收件人" disabled/>
									</div>
									<div class="input-group">
										<select class="wk-select" id="receiver">
										<option value="">--请选择--</option>
										<c:forEach items="${users}" var="var">
											<option value="${var.id}">${var.name}</option>
										</c:forEach>
									</select>
									</div>
								</div>

								
								
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">添加附件:
									</label>
									<div class="input-group">
										<input  name="file" type="file"
											class="form-control wk-normal-input"
											 />
									</div>
								</div>	
						</div>
						</div>
						<div class="row">
						
  							<div class="form-group" style="margin-left:30px;margin-right:50px">
    							消息内容：
    							<textarea class="form-control" rows="4"
    							class="form-control wk-normal-input"
											placeholder="请输入消息内容" name="content"
    							></textarea>
  							</div>
						
						</div>
					</div>

					<div class="panel-footer wk-panel-footer">
						<button type="submit" class="btn btn-default wk-btn">发&nbsp;&nbsp;送</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>