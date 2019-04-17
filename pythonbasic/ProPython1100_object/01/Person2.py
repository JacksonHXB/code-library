class Person(object):
    # name = ""
    # age = 0
    # height = 0
    # weight = 0

    #构造函数
    def __init__(self, name, age, height, weight):
        # 定义属性
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight

    def eat(self, food):
        print("EAT" + food)

    def openDoor(self):
        print("我已经打开了冰箱门！")

    def fillEle(self):
        print("我已经把大象装进冰箱了！")

    def closeDoor(self):
        print("我已经关闭了冰箱门！")











