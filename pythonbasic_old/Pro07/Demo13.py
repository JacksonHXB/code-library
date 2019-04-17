'''
_init_，_str_的使用
'''
class Cat:
    #初始化对象,相当于java中的构造函数
    def _init_(self,newName,newAge):
        self.name=newName
        self.age=newAge
        
    #_str_相当于java中的toString方法
    def _str_(self):
        return "%s的年龄是：%d"%(self.name,self.age)
    
    #定义方法
    def eat(self):
        print("猫在吃饭")
    def drink(self):
        print("猫在喝水")
    def introduce(self):
        print("%s的年龄是:%d"%(self.name,self.age))
        
#创建对象        
tom=Cat("汤姆",40)
print(tom)
    
        
































