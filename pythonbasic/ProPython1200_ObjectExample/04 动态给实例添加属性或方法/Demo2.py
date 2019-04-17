"""
动态的限制属性或方法
"""
from types import MethodType

class Person(object):
    # 限制属性或方法
    __slots__ = ("name", "age", "speak")


p = Person()
p.name = "12"

# 不能添加除限定属性之外的属性
# p.height = 12

# 动态添加方法
def say(self):
    print(self.name)
p.speak = MethodType(say, p)
p.speak()







