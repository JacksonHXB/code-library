<template>
    <div>
        <h1>这是App组件</h1>

        <!-- 使用MintUI-->
        <mt-button type="danger" icon="more" @click="show">default</mt-button>
        <mybtn>我的按钮</mybtn>

        <!-- 使用MUI -->
        <button type="button" class="mui-btn mui-btn-royal">紫色</button>

        <router-link to="/account">Account</router-link>
        <router-link to="/goodslist">GoodsList</router-link>

        <router-view></router-view>

    </div>
</template>

<script>
//导入Toast组件
import {Toast} from 'mint-ui'

export default{
    data(){
        return {
            myToast: null
        }
    },
    created() {     //当组件被创建时，就去获取数据
        this.getList()
    },
    methods:{
        getList(){
            this.show()
            setTimeout(() => {         //模拟获取列表的方法
                this.myToast.close
            }, 3000)
        },
        show(){
            this.myToast = Toast({
                message:'数据加载中....',
                duration: -1,
                position: 'top',
                iconClass: 'glyphicon glyphicon-heart', //这里引用了bootstrap的样式
                className: 'mytoast'       //自定义Toast的样式，需要自己提供一个类名
            }) 
        }
    }
}
</script>

<style></style>



































