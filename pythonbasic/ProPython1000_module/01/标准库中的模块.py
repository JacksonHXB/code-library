"""
引入模块
"""
import sys

# 引入自定义模块方式一
import Module

# 引入自定义模块方式二:从模块中导入一个指定的部分到当前命名空间
from Module2 import sayGood

# 导入自定义模块中的全部信息,这种方式最好不要过多的使用
from Module2 import *


# 获取命令行的参数列表
for i in sys.argv:
    print(i)

# 自动查找所需模块的路径的列表
print(sys.path)

# 使用自定义模块中的内容
Module.sayGood()
Module.sayHandsome()
Module.sayNice()
print("模块中的变量：", Module.TT)

# 使用方式二引入
sayGood()
sayNice()
















































