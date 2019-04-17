'''
继承中的注意点
'''
class A:
    def __init__(self):
        self.num1 = 100
        self.__num2 = 200
    
    def test1(self):
        print("******test1********")
    
    def __test2(self):
        print("*******test2*******")
    
    def test3(self):
        self.__test2()
        print(self.__num2)
        
class B(A):
    # 该方法被调用但不能被执行
    def tes4(self):
        self.__test2()
        print(self.__num2)

b = B()

# 调用普通方法
b.test1()

# 调用私有方法
# b.__test2()

# 调用普通属性
print(b.num1)

# 调用私有属性
# print(b.__num2)

# 通过普通方法调用父类中私有化的属性和方法
b.test3()


































