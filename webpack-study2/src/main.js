//项目的JS入口文件
console.log("-------- 加载main.js文件 --------------------")

import './css/index.css'
//注意，如果要通过路径的形式，去引入node_moudels中相关的文件，可以直接省略路径前面node_modules这一层目录
import 'bootstrap/dist/css/bootstrap.css'

//class关键字，是ES6中提供的新语法，是用来实现ES6中面向对象编程的方式
class Person{
    static info = { name: 'zs', age: 20 }
}

//在webpack中，默认只能处理一部分ES6的新语法，一些更高级的的ES6语法或者ES7语法，这时就会借助第三方loader来帮助webpack处理这些新语法
//通过Babel可以将高级语法转换为低级的语法
//包1：npm i babel-core babel-loader babel-plugin-transform-runtime -D
//包2：npm i npm i babel-preset-env babel-preset-stage-0 -D
console.log(Person.info)
































