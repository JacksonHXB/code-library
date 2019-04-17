'''
类方法，实例方法和静态方法
'''
class Game(object):
    #类属性
    num=0
    
    #实例方法
    def __init__(self):
        #示例属性
        self.name="laoWang"
        
    #类方法
    @classmethod
    def addNum(cls):
        cls.num=100

    #静态方法
    @staticmethod
    def printMenu():
        print("*"*8)
        print("穿越火线")
        print("1，开始游戏")
        print("2，结束游戏")
        print("*"*8)

game=Game()

#调用类方法,(1)使用类的名字调用（2）使用实力对象调用
Game.addNum()
game.addNum()

print(Game.num)

#调用静态方法：（1）通过类调用静态方法,(2)通过实例对象调用
Game.printMenu()
game.printMenu()

























