'''
设计4S店
'''
''' 创建店铺类 '''
class CarStore(object):
    # 买车
    def order(self, carType):
        return selectCarByType(carType)


''' 定义函数 '''
#解耦：将关联性拆开，好处是一个模块的升级不影响另一个模块
def selectCarByType(carType):
    if carType == "索纳塔":
        return Suonata()
    elif carType == "命途":
        return Mingtu()
    elif carType == "ix35":
        return Ix35()

''' 创建车类 '''
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

# 创建车
carStore = CarStore()
# 客户买车
car = carStore.order("ix35")
car.move()
car.music()
car.stop()








































