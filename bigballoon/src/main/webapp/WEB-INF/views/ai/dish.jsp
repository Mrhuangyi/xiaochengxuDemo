<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>菜品推荐页面</title>
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

<style type="text/css"> 
.float{    
	float:left;    
    width : 200px;    
    height: 200px;    
   	overflow: hidden;    
    border: 1px solid #CCCCCC;    
    border-radius: 10px;    
    padding: 5px;    
    margin: 5px;    
}    
img{    
    position: relative;    
}    
.result{    
    width: 200px;    
   	height: 200px;    
  	text-align: center;    
  	box-sizing: border-box;    
}
#file_input{
	display:none;
}

.delete{  
 	width: 200px;  
	height:200px;  
    position: absolute;  
 	text-align: center;  
 	line-height: 200px;  
  	z-index: 10;  
    font-size: 30px;  
    background-color: rgba(255,255,255,0.8);  
  	color: #777;  
 	opacity: 0;  
 	transition-duration: 0.7s;  
 	-webkit-transition-duration: 0.7s;   
}
.delete:hover{ 
	cursor: pointer;
	opacity: 1;
}
</style> 
<body>
	<div class="container"> 
		 <label style="font-size:20px">请选择要上传的菜品：</label> 
	  	 <button style="font-size:16px;margin-right:10px" id="select">选择图片</button> 
	  	 <button style="font-size:16px;margin-right:10px" id="add">添加图片</button>
	  	 <input type="file" id="file_input" multiple/> 
	  	 <button style="font-size:16px" id="submit">提交</button> 
	</div>
	
	<script src="${path}/res/js/myjs/dish.js"></script>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script type="text/javascript">
		var path = "${path}";
	</script>
</body>
</html>