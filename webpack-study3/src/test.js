
/*这是Node中向外暴露成员的形式*/
// module.exports = {

// }
//在Node中使用 var 名称 = require('模块标识符')
//module.exports和export来暴露成员

/*
    在ES6中通过规范的形式，规定了ES6中如何导入和导出模块
    在ES6中使用import {} from './location'
    在ES6使用export default 和export向外暴露成员
*/
var info = {
    name: 'zs',
    age: 20
}
export default info

//通过ES6向外暴露成员
export var title = '小星星'
export var content = "哈哈哈"

//注意1：export default向外暴露的成员，可以使用任意的变量来接收
//注意2：在一个模块中，export default只允许向外暴露一次，不能有多次
//注意3：在一个模块中，可以同时使用export default和export
//注意4：使用export向外暴露成员，只能使用{}的形式来接收，这种方式叫做按需导出,export的接收名称必须与暴露的成员名称一致,如果想要起别名使用as关键字