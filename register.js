// pages/loginer/loginer.js
wx.cloud.init();
let app = getApp();
// 获取云数据库引用
const db = wx.cloud.database();
const admin = db.collection('user_password');
let Sno = null;//变量，用于存放用户输入的学号
let index = 0;
let a = false;

  Page({
    //添加Name
    inputName(event){
      Sno = event.detail.value;
    },
    //添加Age
    //添加数据
    register(){
      admin.get({
        success: (res) => {
          let user = res.data;
          for (let i = 0; i < user.length; i++) {  //遍历数据库对象集合
            if (Sno  === user[i].Sno) {
              a = true; //学号存在
              break;
            } 
          }
          if(a == false){
            admin.where({
              _openid: wx.getStorageSync('openid')
            }).update({
              data: {
                Sno: Sno
              }
             }).then(res=>{
              console.log(res)
              if(res !== null){
                wx.showToast({
                  title: '注册成功！！',
                  icon: 'success',
                  duration: 2500
                  })
                setTimeout(
                  function () {
                  wx.switchTab({
                  url:'/pages/index/index',
                  })}, 
                  1000
                )
              }
            })
          } 
          else{
            wx.showToast({
              title: '注册失败！！',
              icon: 'success',
              duration: 2500
            })
          }
        }
      })
    }
  })