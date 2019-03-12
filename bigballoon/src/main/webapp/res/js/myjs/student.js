layui.use(['layer', 'form', 'table'], function() {
	var $ = layui.$,
		layer = layui.layer,
		form = layui.form,
		table = layui.table;
	
	var tableIns = table.render({
		elem: '#stuTables',
		id: 'stuTables',
		height : 500,
	    width: 1250,
		limit : 20,
        limits : [10,15,20,25],
		cols: [
			[{
				checkbox: true,
				width: 60,
				fixed: true,
			}, {
				field: 'stuID',
				width: 110,
				title: '学号',
			},{
				field: 'name',
				width: 90,
				title: '姓名',
			},{
				field: 'gender',
				width: 60,
				title: '性别',
				align: 'center',
			},{
				field: 'university',
				width: 140,
				title: '学校',
				align: 'center',
			}, {
				field: 'college',
				width: 130,
				title: '学院',
			},{
				field: 'major',
				width: 180,
				title: '专业',
				align: 'center',
			},{
				field: 'stuClass',
				width: 60,
				title: '班级',
				align: 'center',
			},{
				field: 'entryDate',
				width: 110,
				title: '入学时间',
			}, {
				field: 'phone',
				width: 120,
				title: '手机号',
			},{
				title: '常用操作',
				width: 180,
				align: 'center',
				toolbar: '#stubar',
			}]
		],
		url: path + '/student/data.do',
		page: true,
		even: true,
	});
	
	//监听工具条
	table.on('tool(stuTables)', function(obj) {
		var data = obj.data;
	
		if (obj.event === 'edit') {
			var index = layer.open({
				title: "学生信息修改",
				type: 2,
				skin:'',
				offset: ['50px', '350px'],
				area: ['540px', '520px'],
				content: path + "/student/editStudent.do?stuID="+data.stuID,
			});
		}else if (obj.event === 'del') {
			layer.confirm('真的删除该学生么？', function(index) {
				var ajaxReturnData;
		        $.ajax({
		            url: path + '/student/delete.do',
		            type: 'post',
		            async: false,
		            data: {stuID:data.stuID},
		            success: function (data) {
		                ajaxReturnData = data;
		            }
		        });
		        //删除结果
		        if (ajaxReturnData == '0') {
		            table.reload('stuTables');
		            layer.msg('删除成功', {icon: 1});
		        } else {
		        	layer.msg('删除失败', {icon: 5});
		        }
				
				layer.close(index);
				
				
			});
		}
	});
	
	$('#one_group .layui-btn').on('click',function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
	});

	var active = {
        add:function(){
        	var index = layer.open({
				title: "用户编辑",
				type: 2,
				skin:'',
				offset: ['40px', '350px'],
				area: ['540px', '520px'],
				content: path + "/student/addStudent.do",
			});
        },
        edit:function(){
        	
           
        },
        del:function(){
        	
        }

	};
	
	

});