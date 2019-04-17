"""
析构函数：
    __del__() 释放对象时自动调用

"""
class Person(object):
    def run(self):
        print("run")
    def eat(self, food):
        print("eat" + food)
    def __init__(self, name, age, height, weight):
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight
    # 析构函数
    def __del__(self):
        print("这里是析构函数！")

per1 = Person("Jackson", 23, 45, 56)
# 释放内存方式1
del per1

# 释放内存方式2
def func():
    per2 = Person("Tom", 34, 45, 56)
# 当函数结束之时，内存就被释放了
func()
