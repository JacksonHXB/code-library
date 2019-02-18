/*指定打包的入口与出口文件,直接使用"webpack"命令就可以打包，而不用使用"webpack 入口地址 出口地址"命令*/
const path = require('path')
/*
    01 首先，webpack发现，我们并没有通过命令的形式，给它指定入口和出口
    02 webpack就会去项目的根目录中查找webpack.config.js的配置文件
    03 当找到配置文件后，webpack回去解析执行这个配置文件，当解析执行完配置文件后，就得到了配置文件中导出的配置对象
    04 当webpack拿到了配置对象后，就拿到了配置对象中指定的入口和出口，然后进行打包构建
*/

module.exports = {
    //入口，表示要是用webpack打包哪个文件
    entry: path.join(__dirname, './src/main.js'),
    //出口，表示输出文件相关的配置
    output: {
        path: path.join(__dirname, './dist'), //指定输出文件的路径
        filename: 'bundle.js'   //这是指定输出文件的名称
    }
}






























