'''
创建类和对象
'''
class Person:
    #方法
    def eat(self):
        print("人正在吃鱼")
    def drink(self):
        print("人正在喝水")
    def introduce(self):
        #self相当于java中的this
        print("%s的年龄是：%d"%(self.name,self.age))

'''
创建一个对象
'''
#创建小明这个对象，并调用方法
xiaoMing=Person()
xiaoMing.name="小明"
xiaoMing.age=23
#这里相当于xiaoMing.introduce(xiaoMing)
xiaoMing.introduce()
    #这里不用手动传递对象，python会自动传递对象引用

'''
创建多个对象,并调用方法
'''
jack=Person()
jack.name="杰克"
jack.age=12
jack.introduce()



































