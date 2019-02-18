//这是main.js是我们项目的JS文件入口文件

//导入jquery
//由于ES6代码太高级，浏览器解析不了，所以这一行直接会报错
import $ from 'jquery'

$(function(){
    $('li:odd').css('background','red')
    $('li:even').css('background',function(){
        return '#' + 'D97634'
    })
})