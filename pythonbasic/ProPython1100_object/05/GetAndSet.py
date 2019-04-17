"""
属性私有化：
    仅仅在属性前面加上下划线，外部则无法直接访问
    注意：
        1.类似于__age__不是私有化变量，而是属于特殊变量，特殊变量的值可以直接访问
        2.在Python中_age，这样的实例变量外部也是可以访问的
"""
class Person(object):
    def test(self):
        print("This is a test!")

    def __init__(self, name, age, money):
        self.name = name
        self.age = age
        # 私有化属性
        self.__money = money

    # set方法:给私有化属性赋值
    def setMoney(self, money):
        if money > 0:
            self.__money = money
        else:
            print("兄弟你很穷啊！")

    # get方法：获取私有化属性的值
    def getMoney(self):
        return self.__money

p = Person("Tom", 23, 1000)

# 如果内部的属性不被外部直接访问,直接在属性上加上下划线
p.setMoney(1200)
print(p.getMoney())

# 不能直接访问p.__money是因为Python解释器把__money变成了_Person__money
# 仍然可以用_Person__money去访问，但是前列建议不要这么做,不同的解释器解释的变量名不一致
p._Person__money = 0
print(p._Person__money)

# Python可以给对象动态添加属性
p.attribute = "attribute"
print(p.attribute)












































