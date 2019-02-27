//index.js
var hotapp = require('../../utils/hotapp.js');
//获取应用实例
var app = getApp();
const recorderManager = wx.getRecorderManager()
Page({
  data: {
    cancel: false,
    inputValue: [],
    focus: false
  },
  onLoad: function (options) {
    console.log(recorderManager)
  
  },
  //开始录音
  start: function () {
    const options = {
      duration: 60000,//ms,最长只有60s
      sampleRate: 16000,//采样率
      numberOfChannels: 1,//通道数
      encodeBitRate: 96000,
      format: 'mp3',
      frameSize: 50,
    }
    recorderManager.start(options);
    // 开始录音回调
    recorderManager.onStart(() => {
      console.log('开始录音')
    });
    // 错误回调
    recorderManager.onError((res) => {
      console.log(res)
    })
  },

  //停止录音
  stop: function () {
    recorderManager.stop();
    var that = this
    recorderManager.onStop((res) => {
      console.log('停止录音')
      console.log(res)
      console.log(res.tempFilePath)
      wx.uploadFile({
        url: 'http://172.19.0.194:8080/bigballoon/ai/speechRecognition.do',
        filePath: res.tempFilePath,
        name: 'file',
        success: function (res) {
          console.log(res.data);
          that.setData({
            inputValue: res.data.substring(0, res.data.length-1)
          });
        },
        fail: function () {
          console.log("语音识别失败");
        }
      })
    }
    );
    

  },

  longPress: function () {
    console.log('longPress....')
  },

  touchStart: function () {
    console.log('touchStart....')
    this.start()
  },


  touchEnd: function () {
    console.log('touchEnd....')
    this.stop();
  },  
  formSubmit: function (e) {
    var that = this;
    var keyword = null;
    if (e.detail.value.book) {
      keyword = e.detail.value.book;
      that.search(keyword);
    } else {
      wx.showToast({
        title: '您没有输入哦',
        icon: 'success',
        duration: 10000
      })
      setTimeout(function () {
        wx.hideToast()
      }, 1000)
      return false;
    }
  },

  enterSubmit: function (e) {
    var that = this;
    var keyword = null;
    if (e.detail.value) {
      keyword = e.detail.value;
      that.search(keyword);
    } else {
      wx.showToast({
        title: '您没有输入哦',
        icon: 'success',
        duration: 10000
      })
      setTimeout(function () {
        wx.hideToast()
      }, 1000)
      return false;
    }
  },

  search: function (keyword) {
    wx.showToast({
      title: '搜索中',
      icon: 'loading',
      duration: 10000
    })

    hotapp.request({
      url: 'http://api.diviniti.cn/jmu/library/search/' + keyword + '/page/1/count/20',
      success: function (res) {
        wx.hideToast()
        app.globalData.searchResult = res.data;

        wx.navigateTo({
          url: '../result/result?keyword=' + keyword
        })
      },
      fail: function () {
        wx.showToast({
          title: '连接失败',
          icon: 'success',
          duration: 5000
        })
        setTimeout(function () {
          wx.hideToast()
        }, 2000)
      },
      complete: function () {

      }
    })
  },

  //input清除按钮显示
  typeIng: function (e) {
    var that = this;
    if (e.detail.value) {
      that.setData({
        cancel: true
      })
    } else {
      that.setData({
        cancel: false
      })
    }
  },
  //清除输入框
  clearInput: function () {
    console.log(1)
    this.setData({
      inputValue: null,
      cancel: false,
      focus: true
    })
  },
  onShareAppMessage: function () {
    return {
      title: '图书盒子',
      path: '/pages/book/book'
    }
  }


})