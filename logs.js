var util = require('../../utils/util.js')
Page({
  data: {
    logs: [],
    modalHidden: true,
    toastHidden: true,
    nickname:''
  },
  onShow: function() {
    wx.setNavigationBarTitle({
      title: '学习记录'
    })
    this.getLogs()
  },
  set: function() {

  },
  getLogs: function() {
    let logs = wx.getStorageSync('logs')
    logs.forEach(function(item, index, arry) {
      item.startTime = new Date(item.startTime).toLocaleString()
    })
    this.setData({
      logs: logs,
      userInfo: wx.getStorageSync('userInfo')
    })
  },
  onLoad: function() {},
  switchModal: function() {
    this.setData({
      modalHidden: !this.data.modalHidden
    })
  },
  hideToast: function() {
    this.setData({
      toastHidden: true
    })
  },
  clearLog: function(_e) {
    wx.setStorageSync('logs', [])
    this.switchModal()
    this.setData({
      toastHidden: false
    })
    this.getLogs()
  }
})
