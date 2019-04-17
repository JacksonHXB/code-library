'''
私有化方法
'''
class Dog:
    
    #私有化方法，需要在方法名前面加上下划线
    def __test1(self):
        print("-------正在发送短信---")

    #公有化方法
    def test2(self):
        print("--------2-------------")

dog=Dog()
#私有化方法无法调用
# dog.__test1()
dog.test2()































