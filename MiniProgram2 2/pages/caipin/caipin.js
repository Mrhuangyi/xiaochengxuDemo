// pages/caipin/caipin.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dishMenu:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://192.168.1.101:8080/bigballoon/ai/dishRecognition.do',
      success:function(res){
        for(var i=0; i<res.data.length; i++){
          var name = "dishMenu[" + i + "].name"
          var calorie = "dishMenu[" + i + "].calorie"
          var imgUrl = "dishMenu[" + i + "].imgUrl"

            that.setData({
              [name]: res.data[i].name,
              [calorie]: res.data[i].calorie,
              [imgUrl]: res.data[i].imgUrl,
          })
          
        }
        
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