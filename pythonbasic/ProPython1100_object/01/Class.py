"""
设计类
"""
# object表示基类或者是超类，是所有类的父类，一般没有合适的父类就写object
class Person(object):
    # 定义属性
    name = ""
    age = 0
    height = 0
    weight = 0

    # 定义方法(函数)
    # 方法的参数必须以self当第一个参数，这个self代表类的实例（某个对象）
    def eat(self, food):
        print("EAT" + food)

    def openDoor(self):
        print("我已经打开了冰箱门！")

    def fillEle(self):
        print("我已经把大象装进冰箱了！")

    def closeDoor(self):
        print("我已经关闭了冰箱门！")

'''实例化对象'''
per1 = Person()
per2 = Person()
# 比较创建出的两个对象
print(id(per1))
print(id(per2))
print(type(per1))
print(type(per2))

per1.openDoor()
per1.fillEle()
per1.closeDoor()






























