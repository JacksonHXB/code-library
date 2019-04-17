'''
子类的扩展
'''
class Animal:
    def eat(self): 
        print("---------吃--------")
    def drink(self):
        print("*********喝********")

class Dog(Animal):
    def bark(self):
        print("狗汪汪叫！")

class Xiaotq(Dog):
    def fly(self):
        print("********飞**********")
        
#创建哮天犬
xiaoTQ=Xiaotq()
#调用哮天犬特有的功能
xiaoTQ.fly()
#调用狗的特有功能
xiaoTQ.bark()
#调用动物的共有功能
xiaoTQ.eat()


























