/*指定打包的入口与出口文件,直接使用"webpack"命令就可以打包，而不用使用"webpack 入口地址 出口地址"命令*/
const path = require('path')
//启用热更新的第2步
const webpack = require('webpack')
/*
    01 首先，webpack发现，我们并没有通过命令的形式，给它指定入口和出口
    02 webpack就会去项目的根目录中查找webpack.config.js的配置文件
    03 当找到配置文件后，webpack回去解析执行这个配置文件，当解析执行完配置文件后，就得到了配置文件中导出的配置对象
    04 当webpack拿到了配置对象后，就拿到了配置对象中指定的入口和出口，然后进行打包构建
*/
//导入在内存中生成HMTL页面的插件
//只要是插件，都一定要放到plugins节点中去
const htmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
    mode: "production",
    entry: path.join(__dirname, './src/main.js'),//入口，表示要是用webpack打包哪个文件
    output:{
        path: path.join(__dirname, './dist'),//指定输出文件的路径
        filename: 'test.js' //这是指定输出文件的名称
    },
    devServer:{ //这是配置dev-server命令参数的第二种形式
        open: true,                     //自动打开浏览器
        port: 3000,                     //设置启动时候的运行端口
        contentBase: 'src',             //指定托管的根目录
        hot: true                       //启动热更新的第1步
    },
    plugins:[   //配置插件的节点
        new webpack.HotModuleReplacementPlugin(),        //启动热更新的第3步
        new htmlWebpackPlugin({ //这是创建一个在内存中生成html页面的插件
            template: path.join(__dirname, './src/index.html'),  //指定模板页面，将来会根据指定的页面路径，去生成内存中的页面
            filename: 'index.html'      //指定生成页面的名称
        })
    ],
    module:{    //这个节点，用于配置所有第三方模块加载器
        rules:[ //所有第三方模块的匹配规则
            { test: /\.css$/, use: ['style-loader','css-loader'] },   //配置处理*.css文件的第三方规则，调用规则是从右边到左边调用，也就是先调用css-loader
            { test: /\.less$/, use: ['style-loader','css-loader', 'less-loader']}, //处理*.less样式文件的第三方规则
            { test: /\.scss$/, use: ['style-loader','css-loader', 'sass-loader']}, //处理*.scss样式文件的第三方规则
        ]
    }
}






























