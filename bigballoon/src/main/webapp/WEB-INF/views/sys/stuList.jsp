<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>学生管理</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="Shortcut Icon" href="/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="${path}/res/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="${path}/res/font-awesome-4.7.0/css/font-awesome.css" />
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row  animated bounceIn">
    	<div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
    		<fieldset class="layui-elem-field layui-field-title site-title">
                <legend><a name="color-design">学生管理</a></legend>
            </fieldset>
            <div class="layui-btn-group" id="one_group">
                <button class="layui-btn"  data-type="add"><i class="layui-icon">&#xe61f;</i><cite>添加学生</cite></button>
                <!-- <button class="layui-btn layui-btn-normal"  data-type="edit"><i class="layui-icon">&#xe642;</i><cite>修改用户</cite></button>
                <button class="layui-btn layui-btn-danger"  data-type="del"><i class="layui-icon">&#xe640;</i><cite>删除用户</cite></button> -->
            </div>
    	</div>

    	<div class="layui-col-lg10 layui-col-md10 layui-col-sm12 layui-col-xs12">
    		<div class="user-tables">
    			<table id="stuTables" lay-filter="stuTables"></table>
    		</div>
    	</div>
    </div>
</div>
<script type="text/html" id="stubar">
  <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
</script>

<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/res/layui/layui.js"></script> 
<script type="text/javascript" src="${path}/res/js/myjs/student.js"></script> 
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>