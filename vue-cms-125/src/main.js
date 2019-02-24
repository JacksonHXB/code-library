console.log("------- 项目已启动 -----------")

import Vue from 'vue'

//按需导入Mint-UI中的组件
import { Header } from 'mint-ui'
Vue.component(Header.name, Header) 

//导入MUI样式
import './lib/mui/css/mui.min.css'


import app from './App.vue'         //导入App根组件





var vm = new Vue({
    el: '#app',
    render: c => c(app)
})












