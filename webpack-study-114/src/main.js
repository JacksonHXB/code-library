import Vue from 'vue'

//导入Vue-router
import VueRouter from 'vue-router'
Vue.use(VueRouter)

//导入MintUI的所有组件
import MintUI from 'mint-ui'
import 'mint-ui/lib/style.css'  //这里，可以省略
Vue.use(MintUI)                 //把所有的组件，注册为全局组件

//按需导入MintUI组件
import {Button} from 'mint-ui'
Vue.component('mybtn', Button)   //Button.name可以自定义名称为mybtn

//引入MUI组件库
import './lib/mui/css/mui.min.css'


//导入bootstrap样式
import 'bootstrap/dist/css/bootstrap.css'

//导入自定义样式
import './css/app.css'

//导入组件
import app from './App.vue'

//导入router模块
import router from './router.js'

var vm = new Vue({
    el: '#app',
    render: c => c(app),
    router  //挂在router对象
})






























