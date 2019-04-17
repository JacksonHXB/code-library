'''
工厂方法模式
'''
''' 基类 '''
# 基类只负责搭建框架，没有具体的实现过程
class Store(object): 
    # 这里不需要实现功能
    def selectCar(self):
        pass
    
    def order(self, carType):
        return self.selectCar(carType)

#BMW车店
class BMWCarStore(Store):
    def selectCar(self, carType):
        return BMWFactory().selectCarByType(carType)
    
#普通车店
class CarStore(Store):
    def selectCar(self, carType):
        return Factory().selectCarByType(carType)

#BMW生产工厂
class BMWFactory(object):  
    def selectCarByType(self, carType):
        if carType == "mini":
            pass
        elif carType == "720li":
            pass        

#普通车生产工厂
class Factory(object):  
    def selectCarByType(self, carType):
        if carType == "索纳塔":
            return Suonata()
        elif carType == "命途":
            return Mingtu()
        elif carType == "ix35":
            return Ix35()

class Car(object):
    # 创建车的移动方法
    def move(self):
        print("车在移动....")       
    # 创建车的音乐播放方法
    def music(self):
        print("正在听音乐...")
    # 创建停车的方法
    def stop(self):
        print("正在停车...")       

''' 索纳塔车类 '''
class Suonata(Car):
    pass

''' 命途车类 '''
class Mingtu(Car):
    pass

''' Ix35类 '''
class Ix35(Car):
    pass


bmw_store = BMWCarStore()
bmw = bmw_store.order("720li")


# 创建车
carStore = CarStore()
# 客户买车
car = carStore.order("ix35")
car.move()
car.music()
car.stop()








































