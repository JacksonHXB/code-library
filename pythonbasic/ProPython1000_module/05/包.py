"""
思考：如果不同的人编写的模块同名怎么办？

解决方案：
    为了解决模块命名的冲突，我们引入了按目录来组织模块的方法，成为包

特点：
    引入了包以后，只要顶层的包不与其他人发生冲突，那么模块都不会与别人的发生冲突

注意：
    目录只有包含一个叫做”__init__“才被认作是一个包，主要是为了避免一些滥竽充数的单词
"""
import pack1.Module
import pack2.Module


pack1.Module.sayGood()
pack2.Module.sayGood()










































































