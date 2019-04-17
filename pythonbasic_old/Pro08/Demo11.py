'''
多继承的注意点
'''
class Base(object):
    def test(self):
        print("*********Base")
    
class A(Base):
    def test(self):
        print("*********A")

class B(Base):
    def test(self):
        print("*********B")

class C(A,B):
    def test2(self):
        print("*********C")

c=C()
c.test()

#C调用父类被重写的方法，打印父类被重写的方法的搜索顺序
'''
(<class '__main__.C'>, <class '__main__.A'>, <class '__main__.B'>, <class '__main__.Base'>, <class 'object'>)
先调用C中重写的方法，如果没有则调用A中方法，如果没有则调用B中方法，以此向后类推
'''
print(C.__mro__)

































