<template>
    <div>
        <ul class="mui-table-view">
            <li class="mui-table-view-cell mui-media" v-for="item in newslist" :key="item.id">
                <a href="javascript:;">
                    <img class="mui-media-object mui-pull-left" :src="item.img">
                    <div class="mui-media-body">
                        <h1>{{item.title}}</h1>
                        <p class='mui-ellipsis'>
                            <span>发表时间：{{item.time}}</span>
                            <span>点击：{{item.count}}次</span>
                        </p>
                    </div>
                </a>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    created(){
        this.getNewsList()
    },
    data() {
        return {
            newslist: []
        }
    },
    methods: {
        getNewsList(){
            this.newslist = [
                {id:1, title:"这是一个标题1",time:'2019-10-26 14:26', count: '234', img: 'src/images/fenxiang.png'},
                {id:2, title:"这是一个标题2",time:'2019-10-26 14:26', count: '234', img: 'src/images/fenxiang.png'},
                {id:3, title:"这是一个标题3",time:'2019-10-26 14:26', count: '234', img: 'src/images/fenxiang.png'},
                {id:4, title:"这是一个标题4",time:'2019-10-26 14:26', count: '234', img: 'src/images/fenxiang.png'},
                {id:5, title:"这是一个标题5",time:'2019-10-26 14:26', count: '234', img: 'src/images/fenxiang.png'},
                {id:6, title:"这是一个标题6",time:'2019-10-26 14:26', count: '234', img: 'src/images/fenxiang.png'},
            ]
        }
    },
}
</script>

<style lang="css" scoped>
h1{
    font-size:14px;
}
.mui-ellipsis{
    font-size:12px;
    color:#226aff;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
</style>














