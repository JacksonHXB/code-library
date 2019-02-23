var path = require('path')
var htmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
    mode: "production",
    entry: path.join(__dirname, './src/main.js'),   
    output: {
        path: path.join(__dirname, './dist'),
        filename: 'bundle.js'
    },
    plugins:[
        new htmlWebpackPlugin({
            template: path.join(__dirname, './src/index.html'),
            filename: 'index.html'
        })
    ],
    module:{
        rules: [
            {test:/\.css$/, use:['style-loader', 'css-loader']},
            //name=[name].[ext]使用图片的原来名称，而不是进过hash后的图片名称
            {test:/\.(jpg|png|gif|bmp|jpeg)$/, use:['url-loader?limit=7631&name=[hash:8]-[name].[ext]']}      //处理css图片地址,limit限制的是图片的字节数，如果大于该数值，就不会进行base64转换
        ]
    }
}















