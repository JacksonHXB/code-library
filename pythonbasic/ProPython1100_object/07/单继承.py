"""
继承：
    有两个类，A类和B类，当我们说A类继承自B类的时候，那么A类就拥有了B类中所有的属性和方法
    object类是所有类的父类，还可以称为基类或超类
    继承者成为子类，被继承者成为父类

继承的作用：
    1 简化了代码，减少了冗余
    2 提高了代码的健壮性
    3 提高了代码的安全性
    4 是多态的前提

继承的缺点：
    耦合与内聚是描述类与类之间的关系的，耦合性越低，内聚性越高代码越好。但是继承的耦合性很高

继承的分类：
    单继承和多继承

注意：
    1 父类私有的属性，子类无法继承
    2 子类继承父类时，可以有自己独立的属性和方法
"""
# 父类
class Person(object):
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def run(self):
        print("run")

    def eat(self, food):
        print("eat" + food)

# 子类1
class Student(Person):
    def __init__(self, name, age):
        # 调用父类中的__init__方法
        super(Student, self).__init__(name, age)

# 子类2
class Worker(Person):
    def __init__(self, name, age):
        super(Worker, self).__init__(name, age)

stu = Student("Tom", 13)
print(stu.name)
stu.run()

w = Worker("worker", 34)
print(w.name)
w.run()



















