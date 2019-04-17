'''
多继承
'''
#object是超类，在基类中可以省略
class Base(object):
    def test(self):
        print("*********Base")
    
class A(Base):
    def test1(self):
        print("*********test1")

class B(Base):
    def test2(self):
        print("*********test2")

#C类的多继承
class C(A,B):
    pass

#创建c对象
c=C()
#执行A类中的方法
c.test1()
#执行B类中的方法
c.test2()
#执行Base类中的方法
c.test()




































