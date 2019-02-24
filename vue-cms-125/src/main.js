console.log("------- 项目已启动 -----------")

import Vue from 'vue'

//导入Vue路由的包
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import router from './router'

//导入vue-resource
import VueResource from 'vue-resource'
Vue.use(VueResource)


//按需导入Mint-UI中的组件
import { Header, Swipe, SwipeItem } from 'mint-ui'
Vue.component(Header.name, Header) 
Vue.component(Swipe.name, Swipe) 
Vue.component(SwipeItem.name, SwipeItem) 


//导入MUI样式
import './lib/mui/css/mui.min.css'
import './lib/mui/css/icons-extra.css'      //导入MUI的扩展样式


import app from './App.vue'         //导入App根组件

//配置全局的域名
Vue.http.options.root = 'http://www.baidu.com'


var vm = new Vue({
    el: '#app',
    render: c => c(app),
    router
})












