'''
继承
'''
class Animal:  
#动物共有的方法
    def eat(self):
        print("-------吃-------")
    def drink(self):
        print("-------喝-------")

class Dog(Animal):
    
    #子类特有的方法
    def bark(self):
        print("狗汪汪叫！！")

class Cat(Animal):
    def speak(self):
        print("猫喵喵叫!")

'''创建狗'''
dog=Dog()
#执行父类的方法
dog.eat()
#执行子类特有的方法
dog.bark()

'''创建猫'''
cat=Cat()
cat.eat()
cat.speak()



























