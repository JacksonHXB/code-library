console.log("the system is running!")

//如何在webpack构建的项目中，使用Vue进行开发
//复习：
//1,使用script标签，引入vue的包
//2，在index页面中，创建一个id为app div容器
//3,通过new Vue得到一个vm实例

/*
    在webpack中尝试使用vue：
    01 安装vue包 npm i vue -S
*/
//回顾 包的查找规则：
//01 找项目根目录中有没有node_modules的文件夹
//02 根据包名，找对应的vue文件夹
//03 在vue夹中，找一个package.json的包配置文件
//04 在package.json文件中，查找一个main属性【main属性指定了在这个包在加载的时候的入口文件】
//注意： 在webpack中使用import vue from 'vue'导入的Vue构造函数，功能不完整

// import Vue from '../node_modules/vue/dist/vue.js'  //这是最全的方式，导入vue方式一
// import Vue from 'vue'  //导入vue方式二，并在webpack.config.js中添加resolve.alias节点

//以runtime-only的形式导入vue，这种导入包功能不全
import Vue from 'vue' //这个时候，不能使用传统的加载component的方式，应需要创建一个*.vue文件

// var login = {
//     template: '<h1>这是login组件，是使用网页中形式创建出来的组件</h1>'
// }

//导入login.vue组件, 默认webpack无法打包*.vue文件，需要安装相关的loader
//npm i vue-loader vue-template-compilier -D
import login from "./login.vue"

var vm = new Vue({
    el: '#app',
    data: {
        msg: '123'
    },
    // components: {
    //     login
    // }
    //在webpack中，如果想要通过vue把一个组件放到页面中去展示，就需要用render函数可以实现
    // render: function(createElements){
    //     return createElements(login)
    // }
    //简写render函数
    render: c => c(login)
})


import m1, {title, content as contentAlias} from './test.js'
console.log(m1)
console.log(title)
console.log(contentAlias)



























