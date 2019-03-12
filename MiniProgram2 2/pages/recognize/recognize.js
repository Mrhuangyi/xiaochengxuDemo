
Page({
  data: {
    orcText:""
  },
 
  uploads: function () {
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
          console.log(res)

          that.setData({
              img: res.tempFilePaths[0],
              ocrtexts: "",
          })

          wx.showLoading({
              title: "努力识别中..."
          }), 

          wx.uploadFile({
            url:'http://192.168.1.101:8080/bigballoon/ai/ocrRecognition.do',
            filePath: res.tempFilePaths[0],
            header: {
              'content-type': 'multipart/form-data'
            },
            name: 'ocrPic',
            success: function (res) {
                wx.hideLoading()
                console.log(res.data)
                that.setData({
                  orcText: res.data
                })
            },
            fail:function(res){
                wx.hideLoading()
                console.log(res)
            }
          
          })

      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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


})