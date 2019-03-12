// pages/userinfo/userinfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    school: '',
    xueyuan: '',
    zhuanye: '',
    class: '',
    xuehao: '',
    name: '',
    time: '',
    schools: ["浙江中医药大学", "浙江大学", "浙江工业大学"],
    date: "2016-09-01",
    time: "12:01",
    countryIndex: 0,
    xueyuan: ["医学技术学院", "临床学院", "听力学院"],
    xueyuanIndex: 0,
    zhuanye: ["计算机科学与技术", "临床医学", "中医学"],
    zhuanyeIndex: 0,
    information: [],
    modalHidden: true
  },
  checkboxChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value);

    var checkboxItems = this.data.checkboxItems, values = e.detail.value;
    for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
      checkboxItems[i].checked = false;

      for (var j = 0, lenJ = values.length; j < lenJ; ++j) {
        if (checkboxItems[i].value == values[j]) {
          checkboxItems[i].checked = true;
          break;
        }
      }
    }

    this.setData({
      checkboxItems: checkboxItems
    });
  },
  bindDateChange: function (e) {
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    this.setData({
      time: e.detail.value
    })
  },
  bindCountryCodeChange: function (e) {
    console.log('picker country code 发生选择改变，携带值为', e.detail.value);

    this.setData({
      countryCodeIndex: e.detail.value
    })
  },
  bindCountryChange: function (e) {
    console.log('picker country 发生选择改变，携带值为', e.detail.value);

    this.setData({
      countryIndex: e.detail.value
    })
  },
  bindXueyuanChange: function (e) {
    console.log('picker account 发生选择改变，携带值为', e.detail.value);

    this.setData({
      xueyuanIndex: e.detail.value
    })
  },
  bindZhuanyeChange: function (e) {
    console.log('picker account 发生选择改变，携带值为', e.detail.value);

    this.setData({
      zhuanyeIndex: e.detail.value
    })
  },
  //表单提交
  // formSubmit(e) {
  //   console.log(e);
  //   var information = e.detail.value;
  //   this.setData({
  //     information: e.detail.value,
  //     modalHidden: false
  //   });
  // },

  //模态框取消
  modalCancel() {
    wx.showToast({
      title: '取消提交',
      icon: 'none'
    })
    this.setData({
      modalHidden: true,
    })
  },
  //模态框确定
  modalConfirm() {
    wx.showToast({
      title: '提交成功',
      icon: 'success'
    })
    this.setData({
      modalHidden: true
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  formSubmit: function (e) {
    console.log(e);
    var information = e.detail.value;
    this.setData({
      information: e.detail.value,
      modalHidden: false
    });
    wx.request({
      url: 'http://localhost:8080/oneManageM/login/index.do',
      
      data: {
        'username': e.detail.value.name,
        'banji': e.detail.value.banji,
        'xuehao': e.detail.value.xuehao,
        'date': e.detail.value.date,
        'xuexiao': e.detail.value.xuexiao,
        'xueyuan': e.detail.value.xueyuan,
        'zhuanye': e.detail.value.zhuanye
      },
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data)
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})