Page({

  data: {
    show: false,//控制下拉列表的显示隐藏，false隐藏、true显示
    selectData: ['A窗口', 'B窗口', 'C窗口','D窗口'],//下拉列表的数据
    index: 0,//选择的下拉列表下标
    NumA:"",
    NumB:"",
    NumC:"",
    NumD:""
  },
  // 点击下拉显示框
  selectTap() {
    this.setData({
      show: !this.data.show
    });
  },
  // 点击下拉列表
  optionTap(e) {
    let Index = e.currentTarget.dataset.index;//获取点击的下拉列表的下标
    this.setData({
      index: Index,
      show: !this.data.show
    });
  },

  onLoad: function (options) {
    var that = this
    wx.request({
      url: 'http://192.168.1.101:8080/bigballoon/ai/bodyNum.do',
      success:function(res){
        console.log(res.data)
        that.setData({
          NumA: res.data[0],
          NumB: res.data[1],
          NumC: res.data[2],
          NumD: res.data[3],
        })
      }
    })
  }

})