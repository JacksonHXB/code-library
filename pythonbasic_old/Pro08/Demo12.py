'''
多态
'''
class Dog(object):
    def printSelf(self):
        print("大家好，我是XXX，希望以后大家多多关照")

class Xiaotq(Dog):
    def printSelf(self):
        print("hello everybody,我是你们的老大，我是XXX")

#这里temp没有指定类型，所以这里的多态体现的不是很明显
def introduce(temp):
    temp.printSelf()

dog1=Dog()
dog2=Xiaotq()
introduce(dog1)
introduce(dog2)





































