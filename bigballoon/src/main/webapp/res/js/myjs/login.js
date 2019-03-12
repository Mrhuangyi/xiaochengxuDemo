layui.use(['layer', 'form'], function() {
	var layer = layui.layer,
		$ = layui.jquery,
		form = layui.form;
	
	//登录
    form.on('submit(submit)',function(data){
    	var ajaxReturnData;
        //登陆验证
        $.ajax({
            url: path + '/login/login.do',
            type: 'post',
            async: false,
            data: data.field,
            success: function (data) {
                ajaxReturnData = data;
            }
        });
        
        //登陆成功
        if (ajaxReturnData.code == '0') {
            layer.msg(ajaxReturnData.msg, {icon: 1,offset: '100px'});
            setTimeout("window.location.href='"+ path +"/index/index.do'",1000)//延迟一秒跳转登录成功之后界面
            return false;
        } else {
        	layer.msg(ajaxReturnData.msg, {icon: 5,offset: '100px'});
        	return false;
        }
        
    });
    
    
});