<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link rel="shortcut icon" href="${path}/res/images/Ologo.ico" type="image/x-icon" /> 
		<title>登录页面</title>
		<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" >
	  	<link rel="stylesheet" href="${path}/res/font-awesome-4.7.0/css/font-awesome.css" />
	  	<link rel="stylesheet" href="${path}/res/css/mycss/login.css" media="all" /><!-- 要改这个样式文件 -->
	</head>

	<body class="beg-login-bg">
		<div class="beg-login-box">
			<header>
				<h1 style="color:black;font-size:30px;margin-top:50px">氢生活管理系统登录</h1>
			</header>
			<div class="beg-login-main" style="margin-top:50px">
				<form action="" class="layui-form" method="post">
					<div class="avatar">
						<img src="${path}/res/images/login/admin.jpg" width="100px" alt="">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" name="pwd" required lay-verify="required|password" autocomplete="off" placeholder="请输入密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<div class="beg-pull-right">
							<button class="layui-btn " lay-submit lay-filter="submit">
                            <i class="layui-icon">&#xe617;</i> 登录
                        </button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
			<footer>
				<p style="color:black;margin-top:110px;font-size:16px">Powered By EasyLife</p>
			</footer>
		</div>
		
<script src="${path}/res/layui/layui.js"></script>
<script src="${path}/res/js/myjs/login.js"></script><!-- 这个文件要改的 -->
<script type="text/javascript">
var path = "${path}";
</script>
</body>
</html>