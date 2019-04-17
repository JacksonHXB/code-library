"""
动态给实例添加属性和方法
"""
from types import MethodType


# 创建一个空类
class Person(object):
    pass

per = Person()

# 动态添加属性，这体现了动态语言的特点（灵活）
per.name = "Tom"
print(per.name)

# 动态添加方法
def say(self):
    print("my name is " + self.name)
# 使用偏函数，转换为另一个函数
per.speak = MethodType(say, per)
per.speak()








































