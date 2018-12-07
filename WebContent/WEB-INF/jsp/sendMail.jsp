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

</head>

<body>
<div class="row">
    <div class="col-lg-12">
        <ul class="breadcrumb wk-breadcrumb">
            <li>实验室督勤管理系统</li>
            <li>邮件管理</li>
            <li>发送邮件</li>
        </ul>
    </div>
</div>

<div class="row">
    <!-- 注意表单格式，这里需要上传附件 -->
    <form action="SendMailServlet" method="post"  enctype="multipart/form-data">
        <table>
            <tr>
                <td>收件人：</td>
                <td><input type="text" name="to" /></td>
            </tr>
            <tr>
                <td>抄送：</td>
                <td><input type="text" name="copy" /></td>
            </tr>
            <tr>
                <td>主题：</td>
                <td><input type="text" name="title" /></td>
            </tr>
            <tr>
                <td>信件内容：</td>
                <td><textarea rows="10" cols="20" name="content" id="content"></textarea></td>
            </tr>
            <tr>
                <td>附件：</td>
                <td><input type='file' name='ufile' /></td>
            </tr>
            <tr>
                <td>背景音乐：</td>
                <td><input type='file' name='umusic' /></td>
            </tr>
            <tr>
                <td>背景图片：</td><!-- 背景图片我们后台自己准备 -->
                <td>
                    <select name="bgimg">
                        <option value="1">一号</option>
                        <option value="2">二号</option>
                    </select>
                </td>
            </tr>
            <tr align="right">
                <td colspan="2"><input type="submit" value="发 送"></td>
            </tr>
        </table>
    </form>

</div>


<script type="text/javascript" src="resource/lib/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
  window.onload=function(){
    var oFCKeditor = new FCKeditor( 'content' ) ;
    //编译器基本路径
    oFCKeditor.BasePath	= "/";
    //高度
    oFCKeditor.Width=800;
    //宽度
    oFCKeditor.Height=300;
    //工具条集合名称(Default,Basic或自己制定，关于ＦＣＫ的使用，博客内有专门文章)
    //具体的配置可以将默认显示出来然后到FCK目录里的fckconfig.js里
    //FCKConfig.ToolbarSets["Default"]数组中去除不要的功能一共63个功能属性
    //oFCKeditor.ToolbarSet="Basic";
    oFCKeditor.ReplaceTextarea() ;
  }
</script>
</body>

</html>