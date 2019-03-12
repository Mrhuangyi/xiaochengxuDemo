Page({

  data: {
    show: false,//控制下拉列表的显示隐藏，false隐藏、true显示
    selectData: ['阅览室1', '阅览室2', '阅览室3'],//下拉列表的数据
    index: 0,//选择的下拉列表下标
    currentTab:0
  },
  // 点击下拉显示框
  selectTap() {
    this.setData({
      show: !this.data.show
    });
  },
  swiperTab:function(e){
    var that=this;
    that.setData({
      currentTab:e.detail.current
    });
  },
  clickTab:function(e){
    var that=this;
    if (this.currentTab === e.target.dataset.current){
      return false;
    }
    else{
      that.setData({
        currentTab: e.target.dataset.current
      })
    }
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

  }

})