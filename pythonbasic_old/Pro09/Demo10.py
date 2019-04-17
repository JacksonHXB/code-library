'''
只初始化一次2
'''
class Dog(object):
    
    __instance=None
    __initFlag=False
    
    def __new__(cls,name):
        if cls.__instance==None:
            cls.__instance=object.__new__(cls)
            return cls.__instance
        else:
            return cls.__instance
    
    def __init__(self,name):
        if Dog.__initFlag==False:
            self.name=name
            Dog.__initFlag=True
a=Dog("旺财")
b=Dog("哮天犬")
print(id(a))
print(id(b))
print(a.name)
print(b.name)
















































