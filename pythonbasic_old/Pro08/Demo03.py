'''
__del__方法
'''
class Dog:
    #对象在被删除时就会被调用
    def __del__(self):
        print("英雄死了！")

dog1=Dog()
dog2=dog1

#删除引用dog1，但是对象还存在，而且被dog2引用
del dog1

#删除引用dog2，对象没有了引用，__del__被调用
del dog2
print("这是一个测试！")
















