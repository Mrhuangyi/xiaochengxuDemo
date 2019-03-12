Page({
bindtap:function() {
  var that = this;
  wx.request({
    url:'http://120.79.213.104:8080/demo/TestData',
    data: {
      username: '001',
      password: 'abc'
    },
    method: 'GET',
    header: {
      'content-type': 'application/json' // 默认值
    },
    success: function (res) {
      console.log(res.data);
      that.setdata({
        usename:res.data.usename,
        password:res.data.password
      })
    },
    fail: function (res) {
      console.log(".....fail.....");
    }
  })
}
})