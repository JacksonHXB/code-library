//这是main.js是我们项目的JS文件入口文件

//导入jquery
//由于ES6代码太高级，浏览器解析不了，所以这一行直接会报错
import $ from 'jquery'

//注意：webpack，默认只能打包处理JS类型的文件，无法处理其它非JS类型的文件
//如果要处理非JS类型文件，我们需要手动安装一些合适的第三方loader加载器
// 01 如果想要打包处理css文件，需要安装cnpm i style-loader,css-loader -D
// 02 打开webpack.config.js这个配置文件，在里面新增一个配置节点，叫做module,它是一个对象，在module对象上，有一个rules属性，这个rules属性是个数组，这个数组中存放了所有第三方文件匹配和处理规则
import './css/index.css'

/* webpack处理第三方文件类型的过程
    01 返现这个要处理的文件不是JS文件，然后就去配置文件中查找有没有对应的第三方loader规则
    02 如果能找到对应的规则，就会调用对应的loader处理这种文件类型
    03 在调用loader的时候是从后往前调用的；
    04 当最后的一个loader调用完毕会把处理的结果交给webpack打包合并，并输出到bundle.js文件中
*/

import './css/index.less'
import './css/index.scss'

$(function(){
    $('li:odd').css('background','yellow')
    $('li:even').css('background',function(){
        return '#' + 'D97634'
    })
})