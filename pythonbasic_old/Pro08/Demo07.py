'''
重写
'''
class Animal:
    def eat(self):
        print("*******吃**********")

class Dog(Animal):
    def bark(self):
        print("汪汪叫")

class Xiaotq(Dog):
    def fly(self):
        print("******飞*******")
        
    #子类重写父类的方法
    def bark(self):
        print("******狂叫********")
        #第一种：调用被子类重写的父类中的方法
        Dog.bark(self)
        
        #第二种：
        super().bark()

xDog=Xiaotq()
#调用子类重写父类的方法，先执行子类重写的方法，后执行调用父类被重写的方法
xDog.bark()






























