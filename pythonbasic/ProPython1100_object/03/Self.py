"""
self:代表类的实例，而非类那个对象调用方法，那么该方法中的self就代表那个对象
self.__class__代表类名
"""
class Person():
    def run(self):
        print("run")
    def eat(self, food):
        print("eat " + food)
    def say(self):
        print("Hello! my mae is %s,I am %d years old!" % (self.name, self.age))
        # 输出类名
        print(self.__class__)
        # 通过类名创建对象
        p = self.__class__("test", 20, 23, 23)
        print(p)
    def __init__(self, name, age, height, weight):
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight


per1 = Person("Jackson", 20, 160, 80)
per1.say()


per2 = Person("Tom", 21, 180, 80)
per2.say()
























































