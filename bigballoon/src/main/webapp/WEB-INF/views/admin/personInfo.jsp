<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>管理员信息管理界面</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" >
	<link rel="stylesheet" href="${path}/res/font-awesome-4.7.0/css/font-awesome.css" />
	<link rel="stylesheet" href="${path}/res/css/mycss/user.css" media="all" />
</head>
<body class="childrenBody">
	<fieldset class="layui-elem-field">
	  <legend>个人信息</legend>
	  <div class="layui-field-box">
	    <form class="layui-form">
			<div class="user_left">
				<div class="layui-form-item">
				    <label class="layui-form-label">用户名</label>
				    <div class="layui-input-block">
				    	<input type="text" name="loginName" value="${admin.loginName }"  disabled class="layui-input layui-disabled">
				    </div>
				</div>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">职工号</label>
				    <div class="layui-input-block">
				    	<input type="text" name="stfID" value="${staff.stfID}" disabled lay-verify="required" class="layui-input">
				    </div>
				</div>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">入职时间</label>
				    <div class="layui-input-block">
				    	<input type="text" name="jobDate" value="${staff.jobDate}" disabled lay-verify="required" class="layui-input">
				    </div>
				</div>

				<div class="layui-form-item">
				    <label class="layui-form-label">姓名</label>
				    <div class="layui-input-block">
				    	<input type="text" name="name" value="${staff.name}" placeholder="请输入姓名" lay-verify="required" class="layui-input">
				    </div>
				</div>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">所属单位</label>
				    <div class="layui-input-block">
				    	<input type="text" name="department"  value="${staff.department}" placeholder="请填写所在单位" lay-verify="required" class="layui-input">
				    </div>
				</div>
	
				<div class="layui-form-item">
				    <label class="layui-form-label">人员职称</label>
				    <div class="layui-input-block">
				    	<input type="text" name="title"  value="${staff.title}" placeholder="请输入职称" lay-verify="required" class="layui-input">
				    </div>
				</div>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">手机号码</label>
				    <div class="layui-input-block">
				    	<input type="tel" name="phone"  value="${staff.phone}" placeholder="请输入手机号码" lay-verify="required|phone" class="layui-input">
				    </div>
				</div>
				
			</div>
			<div class="user_right">
				<button type="button" class="layui-btn" id="test1">
				  <i class="layui-icon">&#xe67c;</i>上传图片
				</button> 
				<input type="file" name="file（可随便定义）" class="layui-upload-file" multiple />
				<p>请选择一张图片上传作为头像</p>
				<img src="" class="layui-circle" id="imgg" width="200px" height="200px">
				<input type="hidden" id="img" name="img" value="">
			</div>
			<div class="layui-form-item" style="margin-left: 5%;">
			    <div class="layui-input-block">
			    	<button class="layui-btn" lay-submit="" lay-filter="changeUser"><i class="fa fa-save"></i>&nbsp;保存信息</button>
					<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			    </div>
			</div>
		</form>
	  </div>
	</fieldset>
	
	<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
	<script type="text/javascript" src="${path}/res/js/myjs/adminInfo.js"></script>
	<script type="text/javascript">
	var path = "${path}";
	</script>
</body>
</html>