<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>添加学生</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="Shortcut Icon" href="/favicon.ico" />
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${path}/res/layui/css/layui.css" media="all">
</head>
<style type="text/css" media="screen">

	.one-tj{
		margin-left: 10px;
		margin-right: 25px;
	}
	.one-btn-btn{
		width: 230px;
		padding-top: 10px;
		margin: 0 auto;
	}
	.layui-form .layui-form-label{
		padding-left: 15px;
		color: #666666;
	}
	.layui-form .layui-input-block{
		width: 300px;
	}
	.layui-form .layui-input-block input,.layui-form .layui-input-block textarea{
		color: #111111;
	}
</style>
<body>
<div class="layui-fluid">

    <fieldset class="layui-elem-field layui-field-title site-title">
      <legend><a name="methodRender">编辑学生</a></legend>
    </fieldset>
  <form class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">学号</label>
			<div class="layui-input-block">
				<input type="text" name="stuID" value="${stu.stuID}" class="layui-input linksName" lay-verify="required" placeholder="请输入学号">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" name="name" value="${stu.name}" class="layui-input" lay-verify="required" placeholder="请输入姓名">
			</div>
		</div>
		<div class="layui-form-item">
    		<label class="layui-form-label">性别</label>
    		<div class="layui-input-block">
    		<c:if test="${stu.gender=='男'}">
    			<input type="radio" name="gender" value="男" title="男" checked>
    			<input type="radio" name="gender" value="女" title="女" >
    		</c:if> 
      		<c:if test="${stu.gender=='女'}">
      			<input type="radio" name="gender" value="男" title="男" >
      			<input type="radio" name="gender" value="女" title="女" checked>
      		</c:if>
      		<c:if test="${stu.gender==null}">
      			<input type="radio" name="gender" value="男" title="男" lay-verify="required">
      			<input type="radio" name="gender" value="女" title="女" lay-verify="required">
      		</c:if>
    		</div>
   	  	</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学校</label>
			<div class="layui-input-block">
				<input type="text" name="university" value="${stu.university}" class="layui-input" lay-verify="required" placeholder="请输入学校">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学院</label>
				<div class="layui-input-block">
				<c:if test="${stu.college!=null}">
					<input type="text" name="college" value="${stu.college}" class="layui-input" lay-verify="required" placeholder="请输入学院">
				</c:if>
				<c:if test="${stu.college==null}">
					<select name="college" lay-verify="required">
						<option selected="selected">请选择学院</option>
						<option value="AAA学院">AAA学院</option>
						<option value="BBB学院">BBB学院</option>
						<option value="CCC学院">CCC学院</option>
					</select>
				</c:if>
				</div>
		</div>
			<div class="layui-form-item">
			<label class="layui-form-label">专业</label>
			<div class="layui-input-block">
				<input type="text" name="major" value="${stu.major}" class="layui-input" lay-verify="required" placeholder="请输入专业">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">班级</label>
			<div class="layui-input-block">
				<c:if test="${stu.stuClass!=null}">
					<input type="text" name="stuClass" value="${stu.stuClass}" class="layui-input" lay-verify="required" placeholder="请输入班级">
				</c:if>
				<c:if test="${stu.stuClass==null}">
					<select name="stuClass" lay-verify="required">
						<option selected="selected">请选择班级</option>
						<option value="1班">1班</option>
						<option value="2班">2班</option>
						<option value="3班">3班</option>
					</select>
				</c:if>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">入学时间</label>
			<div class="layui-input-block">
				<input type="text" name="entryDate" value="${stu.entryDate}" class="layui-input" lay-verify="required" placeholder="请填写入学时间">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-block">
				<input type="text" name="phone" value="${stu.phone}" class="layui-input" lay-verify="required|phone" placeholder="请输入手机号码">
			</div>
		</div>
	
		<div class="layui-form-item one-btn-btn">
				<button class="layui-btn one-tj" lay-submit lay-filter="add">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</form>
</div>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/res/layui/layui.js"></script> 
<script type="text/javascript">
	var path = "${path}";
	var linkType = "${linkType}";
	
	layui.use(['form','layer','jquery'],function(){
		   var $ = layui.$,
		   form = layui.form,
		   layer = layui.layer;
		   
		   form.on('submit(add)',function(data){
		     var ajaxReturnData;
		        //登陆验证
		        $.ajax({
		            url: path + '/student/save.do?type='+linkType,
		            type: 'post',
		            async: false,
		            data: data.field,
		            success: function (data) {
		                ajaxReturnData = data;
		            }
		        });
		        //结果回应
		        if (ajaxReturnData == '0') {
		        	top.layer.msg('保存成功', {icon: 1});
		            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		            parent.layer.close(index); //再执行关闭                        //刷新父页面
		            parent.location.reload();
		        } else  if (ajaxReturnData == '1'){
		        	top.layer.msg('学号已存在', {icon: 5});
		        } else  {
		        	top.layer.msg('保存失败', {icon: 5});
		        }
		        return false;
		   });
		});
</script>
</body>
</html>