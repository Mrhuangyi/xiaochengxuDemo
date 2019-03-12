//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    routers: [
      {
        id: '0',
        name: '查看空座位',
        url: '../kong/kong',
        icon: '/images/library.png'
      },
      {
        id: '1',
        name: '个性化推荐',
        url: '../tui/tui',
        icon: '/images/tuijian.png'
      },
      {
        id: '2',
        name: '语音搜书',
        url: '../book/book',
        icon: '/images/yuyin.png'
      },
      {
        id: '3',
        name: '生僻字识别',
        url: '../recognize/recognize',
        icon: '/images/jieshi.png'
      }
    ],
    routers2: [
      {
        id: '0',
        name: '食堂人流图',
        url: '../renliu/renliu',
        icon: '/images/shitang.png'
      },
      {
        id: '1',
        name: '今日菜品',
        url: '../caipin/caipin',
        icon: '/images/cai.png'
      },
    ],
    imgUrls: [
      'http://m.iqiyipic.com/u5/image/20180311/28/c0/uv_5010537404_m_601_180_101.jpg',
      'https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=3386e39a49fbfbeddc0c3e7948c0db0e/32fa828ba61ea8d3943606a1950a304e251f587a.jpg',
      'http://img04.sogoucdn.com/app/a/100520093/ca86e620b9e623ff-d72d635343d5bade-dcf2acda7a45cb44f172db138bdf8d2d.jpg',
    ],

  },
  toPage: function (event) {
    console.info(event.currentTarget.id);
    var route = event.currentTarget.id;
    if (route == 0) {
      wx.navigateTo({
        url: '/pages/kong/kong',
      })
    } else if (route == 1) {
      wx.navigateTo({
        url: '/pages/tui/tui',
      })
    } else if (route == 2) {
      wx.navigateTo({
        url: '/pages/book/book',
      })
    } else if (route == 3) {
      wx.navigateTo({
        url: '/pages/recognize/recognize',
      })
    }
  },
  toPage2: function (event) {
    console.info(event.currentTarget.id);
    var route = event.currentTarget.id;
    if (route == 0) {
      wx.navigateTo({
        url: '/pages/renliu/renliu',
      })
    } else if (route == 1) {
      wx.navigateTo({
        url: '/pages/caipin/caipin',
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.info(options)
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
