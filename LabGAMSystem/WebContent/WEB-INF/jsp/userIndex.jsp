<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>实验室督勤管理平台</title> 
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="resource/bootstrap/css/bootstrap.min.css" >    
	<link rel="stylesheet" href="resource/bootstrap/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="resource/lib/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="resource/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resource/css/wukong-ui.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap-select.min.css">
    <script type="text/javascript" src="bootstrap/js/bootstrap-select.min.js"></script>
<style>
	.head{
		background:#fff !important;font-weight:bold !important;font-size:16px !important;
	}
	
	.item{
	background:#fff !important; color:#000 !important;
	}
</style>
</head>

<body>
    <div class="row">
        <div class="col-lg-12">
            <div class="banner" id="banner"></div>
        </div>
    </div>
<!--  
    <div class="row">
        <div class="col-lg-12">
            <ul class="nav nav-tabs wk-nav-menu" id="wk-nav-menu">
            
               <li style="color:#fff;font-size:18px; margin-top:10px;margin-left:15px;margin-right:15px">欢迎您！${user.name}</li>
                <li role="presentation"><a href="<%=basePath%>logout.html" class="wk-main-menu-item">注销登录</a></li>    
            </ul>
        </div>
    </div>
    -->
    <div class="row">
    
     	<div class="col-lg-2" style="height:100px; width:320px; border:1px solid #ccc;margin:5px;background:#fff;">
     		<div style="float:left">
     		
     			<img src="resource/images/2.png" height="95px" width="95px" style="margn-top:5px;"/>
     		</div>
     		<div style="float:left;margin-left:10px;margin-top:20px;">
				欢迎您！${user.name}<br/>
				[普通用户] <a href="<%=basePath%>logout.html" class="wk-main-menu-item">注销登录</a>
			</div>
     	</div>
        <div class="col-lg-9" style="height:100px; border:1px solid #ccc;margin:5px;">
          <ul class="nav nav-tabs" >
            
                <li role="presentation"><a href="javascript:void(0);" id="wk-menu-panel-item-createProject" class="wk-main-menu-item">新增项目</a></li>
                <li role="presentation"><a href="javascript:void(0);" id="wk-menu-panel-item-createUserSchedule" class="wk-main-menu-item">新增日程</a></li>
                <li role="presentation"><a href="javascript:void(0);" id="wk-menu-panel-item-message/inbox" class="wk-main-menu-item">收件箱</a></li>
                
            </ul>
            <div style="font-size:20px; color:#ccc; margin-top:12px;font-weight:bold">欢迎使用实验室督勤管理系统！</div>
      
        </div>
    </div>
    <div class="row">
        <div class="col-lg-2" id="wk-menu-panel">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default wk-menu-panel-header">
                        <div class="panel-body wk-menu-panel-body">
                            实验室
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel-group wk-accordion-panel-group" id="accordion">         
                        <div class="panel panel-info ">
                            <div class="panel-heading head"> 
                                <a data-toggle="collapse" href="#BMenu" data-parent="#accordion">日程管理</a>
                            </div>
                             <div id="BMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-createUserSchedule"> >&nbsp;&nbsp;新增日程</button>
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-searchUserSchedule"> >&nbsp;&nbsp;日程查询</button>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#CMenu" data-parent="#accordion">档案管理</a>
                            </div>
                           
                            <div id="CMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-searchMyDoc"> >&nbsp;&nbsp;我的档案</button>
                                </div>
                            </div>

                        </div>
                        
                        <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#DMenu" data-parent="#accordion">公告管理</a>
                            </div>
                            <div id="DMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-searchNewsInfo"> >&nbsp;&nbsp;公告查询</button>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#EMenu" data-parent="#accordion">文件管理</a>
                            </div>
                            <div id="EMenu" class="panel-collapse collapse">
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-file"> >&nbsp;&nbsp;文件管理</button>
                                </div>
                            </div>
                        </div>

                        
                        <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#ZMenu" data-parent="#accordion">项目管理</a>
                            </div> 
                            <div id="ZMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-createProject"> >&nbsp;&nbsp;新增项目</button>
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-searchProject"> >&nbsp;&nbsp;项目信息查询</button>
                                </div>
                            </div>
                        </div>
						


                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default wk-menu-panel-header">
                        <div class="panel-body wk-menu-panel-body">
                            项目补贴
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel-group wk-accordion-panel-group" id="accordion2">   
                    <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#FMenu" data-parent="#accordion2">签到管理</a>
                            </div>
                            <div id="FMenu" class="panel-collapse collapse">
                                <div class="list-group wk-accordion-list-group">
                                    <!-- <button type="button" class="list-group-item" id="wk-menu-panel-item-createAttendance"> >&nbsp;&nbsp;录入考勤数据</button>
                                     -->
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-searchAttendanceByUser"> >&nbsp;&nbsp;签到数据查询</button>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#GMenu" data-parent="#accordion2">补贴管理</a>
                            </div>
                            <div id="GMenu" class="panel-collapse collapse">
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-searchUserWages2"> >&nbsp;&nbsp;补贴查询</button>
                                </div>
                            </div>
                        </div>
             </div>
             </div>
             </div>
            
            
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default wk-menu-panel-header">
                        <div class="panel-body wk-menu-panel-body">
                            消息中心
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel-group wk-accordion-panel-group" id="accordion3">
                    <div class="panel panel-info ">
                            <div class="panel-heading head">
                                <a data-toggle="collapse" href="#MMMenu" data-parent="#accordion3"> 消息管理</a>
                            </div>
                            <div id="MMMenu" class="panel-collapse collapse">
                            <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-message/sendmessage"> >&nbsp;&nbsp;发送消息</button>
                                </div>
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-message/inbox"> >&nbsp;&nbsp;收件箱</button>
                                </div>

                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item item" id="wk-menu-panel-item-message/outbox"> >&nbsp;&nbsp;发件箱</button>
                                </div>
                            </div>
                        </div>    
            </div>  
            </div>  
            </div>   
             
        </div>
        
         <div class="col-lg-10" style="padding:0px;height:800px;" >
             
            <iframe id="mainFrame" src="<%=basePath%>searchNewsInfo2.html" height="800" width="100%" frameborder="0" onload="changeFrameHeight()" >
            </iframe>
            
         </div>
    </div>
    
    <script>
        function changeFrameHeight() {
            var ifm= document.getElementById("mainFrame"); 
            //ifm.height = document.documentElement.clientHeight - $("#wk-nav-menu").height() - $("#banner").height() - 9;
        }
        window.onresize=function(){  
             changeFrameHeight();  
        } 
        
        changeMenuPanelHeight();
        function changeMenuPanelHeight() {
            var panel= $("#wk-menu-panel"); 
            panel.height(document.documentElement.clientHeight - $("#wk-nav-menu").height() - $("#banner").height() - 3);
            
        }
        window.onresize=function(){  
             changeMenuPanelHeight();  
        } 
        
        
        $(".list-group-item").each(function() {
            $(this).on("click", function() {
                var url = "";
                var id = $(this).attr("id").substr(19, $(this).attr("id").length);
                
                $("#mainFrame").attr("src",  "<%=basePath%>" + id + ".html"); 
            });
        });

        $(".wk-main-menu-item").each(function() {
            $(this).on("click", function() {
                var url = "";
                var id = $(this).attr("id").substr(19, $(this).attr("id").length);
                
                $("#mainFrame").attr("src",  "<%=basePath%>" + id + ".html");  
            });
        });

        

    </script>

</body>
</html>