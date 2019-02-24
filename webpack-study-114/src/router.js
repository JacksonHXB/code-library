import VueRouter from 'vue-router'

import account from './main/Account.vue'
import goodslist from './main/GoodsList.vue'
//导入子组件
import login from './subcom/login.vue'
import register from './subcom/register.vue'


var router = new VueRouter({
    routes: [
        { path: '/account', component: account, children: [
            { path: 'login', component: login },
            { path: 'register', component: register }
        ] },
        { path: '/goodslist', component: goodslist },
        { path: '/login', component: login }
    ]
})

//注意：App这个组件，通过VM实例的render函数渲染出来的，render函数渲染出来的组件，只能放在el:'#app'所指定的元素中
//Account和GoodsList组件，是通过路由匹配监听到的，所以这两个组件，只能展示到属于路由的<router-view></router-view>中


//把路由对象暴露出去
export default router