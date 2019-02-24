<template>
    <div>
        <h1>这是登录组件，使用*.vue定义出来的组件--{{msg}}</h1>
    </div>
</template>

<script>
export default{ 
    data(){ //注意：组件中data必须是function
        return {
            msg: '123'
        }
    },
    methods: {
        show(){
            console.log("调用了login.vue中show的方法")
        }
    }
}
</script>

<style>
    
</style>







































