'''
属性的隐藏
'''
class Dog:
    def setAge(self,age):
        if age>0 and age<=100:
            self.age=age
        else:
            self.age=0
            
    def getAge(self):
        return self.age
      
dog=Dog()
dog.setAge(-10)
age=dog.getAge()
print(age)






























































