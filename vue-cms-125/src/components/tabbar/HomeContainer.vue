<template>
    <div>
        <!-- 轮播图区域 -->
        <mt-swipe :auto="4000">
            <!-- 在组件中循环时，一定要加上key -->
            <mt-swipe-item v-for="item in lunbotuList" :key="item.id">
                <img :src="item.img" alt="">
            </mt-swipe-item>
        </mt-swipe>

        <!-- 九宫格到六宫格 -->
        <ul class="mui-table-view mui-grid-view mui-grid-9">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                <router-link to="/home/newslist">
                    <img src="../../images/xinwen.png" alt="">
                    <div class="mui-media-body">新闻资讯</div>
                </router-link>
            </li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><router-link to="#">
                <img src="../../images/fenxiang.png" alt="">
                <div class="mui-media-body">图片分享</div></router-link></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><router-link to="#">
                <img src="../../images/goumai.png" alt="">
                <div class="mui-media-body">商品购买</div></router-link></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><router-link to="#">
                <img src="../../images/liuyan.png" alt="">
                <div class="mui-media-body">留言反馈</div></router-link></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><router-link to="#">
                <img src="../../images/shipin.png" alt="">
                <div class="mui-media-body">视频专区</div></router-link></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><router-link to="#">
                <img src="../../images/lianxi.png" alt="">
                <div class="mui-media-body">联系我们</div></router-link></li>
        </ul> 
    </div>
</template>

<script>
import {Toast} from 'mint-ui'

export default{
    created(){
        this.getLunbotu()
    },
    data(){
        return {
            lunbotuList: [] //保存轮播图数据
        }
    },
    methods: {
        getLunbotu(){  //获取轮播图数据的方法
            // this.$http.get('http://vue.studyid.ip/api/getlunbo').then(res => {
            //     console.log(result.body)
            // })
            this.lunbotuList = [
                {id: "1", img:"http://img.zcool.cn/community/01d7c85949fb51a8012193a3791279.jpg@1280w_1l_2o_100sh.jpg"},
                {id: "2", img:"http://img.hb.aicdn.com/f00d7ab79f6528b90b1dbfa4d41191ba5592d4a440b7-WBmco0_fw658"},
                {id: "3", img:"http://img.hb.aicdn.com/9b671d17b52639d35e7c76c23f79fbabebe769d43140-xjB5Tw_fw658"},
                {id: "4", img:"http://img.hb.aicdn.com/2645661802c88bbe24232b297df760eb1a77fe34462f-ok1bT2_fw658"},
            ]
            // Toast("加载轮播图成功")
        }
    }
}
</script>


<style lang="css" scoped>
.mint-swipe{
    height:200px;
}
.mint-swipe-item:nth-child(1){
    background-color: red;
}
.mint-swipe-item:nth-child(2){
    background-color: green;
}
.mint-swipe-item:nth-child(3){
    background-color: blue;
}
img{
    width:100%;
    height:100%;
}
.mui-grid-view .mui-grid-9{
    background:white;
    border:none;
}
.mui-grid-view .mui-grid-9 .mui-table-view-cell{
    border:none;
}
li img{
    width: 50px;
    height: 50px;
}
.mui-media-body{
    font-size: 13px;
}
</style>
