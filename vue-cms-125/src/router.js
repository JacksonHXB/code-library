import VueRouter from 'vue-router'

//导入对应的路由组件
import HomeContainer from './components/tabbar/HomeContainer.vue'
import MemberContainer from './components/tabbar/MemberContainer.vue'
import ShopcarContainer from './components/tabbar/ShopcarContainer.vue'
import SearchConatiner from './components/tabbar/SearchContainer.vue'
import NewsList from './components/news/NewsList.vue'

var router = new VueRouter({
    routes: [
        { path: '/', redirect: '/home'},
        { path: '/home', component: HomeContainer },
        { path: '/member', component: MemberContainer },
        { path: '/shopcar', component: ShopcarContainer },
        { path: '/search', component: SearchConatiner }, 
        { path: '/home/newslist', component: NewsList }
    ],
    linkActiveClass: 'mui-active'   //默认覆盖路由高亮的类router-link-active
})

export default router


































