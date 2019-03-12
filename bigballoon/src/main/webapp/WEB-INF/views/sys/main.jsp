<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>氢生活后台系统首页</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${path}/res/css/mycss/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${path}/res/css/mycss/main.css" media="all" />
</head>
<body class="childrenBody" >
		<div class="sysNotice col"  ">
			<blockquote class="layui-elem-quote title">基本信息展示图</blockquote>
			<div class="layui-elem-quote layui-quote-nm" ">
				<div id="main1" style="width: 500px;height:250px;"></div>
				<div id="main2" style="width: 500px;height:250px;"></div>
			</div>
		</div>
	<script src="${path}/res/layui/layui.js"></script>
	<script src="${path}/res/js/other-js/echarts.js"></script><!-- 图表js -->
	<script type="text/javascript">
		var path = "${path}";
		var map = ${InfoMap};
		
	</script>
	<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var chart1 = echarts.init(document.getElementById('main1'));
        var chart2 = echarts.init(document.getElementById('main2'));
		
        
        // 指定图表的配置项和数据
        var option1 = {
            title: {
                text: '人员信息'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ["学生","职工","书籍"]
            },
            yAxis: {
            	max:10
            },
            series: [{
                name: '数量',
                type: 'bar',
                data: [map.stuNo,map.staffNo,map.bookNo]
            }]
        };
        
        var option2 = {
                title: {
                    text: '学生年级信息'
                },
                tooltip: {},
                xAxis: {
                    data: ["2016级","2017级","2018级"]
                },
                yAxis: {
                	splitNumber:5,
                	max:5,
                },
                series: [{
                    name: '数量',
                    type: 'bar',
                    data: [map.grd16No, map.grd17No,map.grd18No]
                }]
            };
        

        // 使用刚指定的配置项和数据显示图表。
        chart1.setOption(option1);
        chart2.setOption(option2);
    </script>
</body>
</html>