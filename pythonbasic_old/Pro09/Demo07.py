'''
__new__()和__init__()
'''
class Dog(object):
    #初始化
    def __init__(self):
        print("----init方法--------")
    
    def __del__(self):
        print("----del方法--------")
        
    #类似于toString方法
    def __str__(self):
        print("----str方法--------")
        return "对象的描述信息"
    
    #创建对象
    def __new__(cls):#cls此时是Dog指向的那个类对象      
        print(id(cls))    
        print("----new方法--------")
        return object.__new__(cls)

print(id(Dog)) 
  
xtq=Dog()
'''
相当于要做3件事：
1）调用__new__()创建对象，然后找了一个变量来接收__new__的返回值，这个返回值表示创建出来的对象的引用
2）调用__init__（刚刚创建出来的对象的引用） 
3）返回对象的引用
构造方法：是既创建又初始化
而__new__和____是分开进行创建和初始化
'''















































