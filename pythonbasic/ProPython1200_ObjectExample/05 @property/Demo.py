"""
@property
    使用该注解限制用户访问属性

"""
class Person(object):
    def __init__(self, age):
        # self.age = age
        self.__age = age

    # 限制访问
    # def setAge(self, age):
    #     self.__age = age
    # def getAge(self):
    #     return self.__age

    # 使用@property限制访问
    @property        # 当取值的时候就调用这个方法
    def age(self):
        return self.__age
    @age.setter      # 当赋值的时候调用这个方法
    def age(self, age):
        self.__age = age




p = Person(12)

'''这样的属性对外暴露，不安全，没有数据的过滤'''
# p.age = 100
# print(p.age)


'''使用限制访问，需要自己写set和get方法'''
# p.setAge(100)
# print(p.getAge())


'''使用@property'''
p.age = 100
print(p.age)

















































