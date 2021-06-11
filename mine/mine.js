// pages/mine/mine.js
Page({
  data:{
    userInfo:""
  },
  login(){
    wx.getUserProfile({
      desc:'为了更好的使用小程序，请先授权',
      success:res=>{
        let user = res.userInfo
        console.log("授权成功",res)
        this.setData({
          userInfo:user
        })
        console.log(user)

      },
      fail:res=>{
        console.log("授权失败")
      }
    })
  },
  loginout(){
    this.setData({
      userInfo:""
    })

  }
})