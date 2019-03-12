

Page({

  /**
   * 页面的初始数据
   */
  data: {
    press:"",
    author:"",
    imgUrl: "",
    location:"",
    synopsis:"",
    sort:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var keyword = options["name"]
    var that = this
    wx.request({
      url: 'http://192.168.1.101:8080/bigballoon/book/lookByName.do?name=' + keyword,
        success: function (res) {
            console.log(res.data)
            that.setData({
              press: res.data["press"],
              author: res.data["author"],
              imgUrl: res.data["imgUrl"],
              location: res.data["location"],
              synopsis: res.data["synopsis"],
              sort: res.data["sort"]
            })
        },
        fail: function () {
            console.log("搜书失败！")
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