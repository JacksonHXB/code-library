"""
提款机
"""

from card import Card
from user import User
import random
import time

class ATM(object):
    def __init__(self):
        self.allUsers = {}

    # 开户
    def createUser(self):
        name = input("请输入您的姓名：")
        idCard = input("请输入你的身份证号：")
        phone = input("请输入您的电话号码：")
        prestoreMoney = int(input("请输入预存款金额:"))
        if prestoreMoney < 0:
            print("预存款输入有误，开户失败！")
            return -1
        onePasswd = input("请输入密码：")

        # 随机生成卡号
        cardStr = self.randomCardId()

        # 生成User对象，并存入字典中
        userCard = Card(cardStr, onePasswd, prestoreMoney)
        user = User(name, idCard, phone, userCard)
        self.allUsers[cardStr] = user
        print("开户成功，请牢记卡号！%s" % (cardStr))
        time.sleep(1)

    # 查询
    def searchUserInfo(self):
        user = self.checkCard()
        print("你的账户余额为：%s" % (user.card.cardMoney))


    '''取款'''
    def getMoney(self):
        pass

    '''存款'''
    def saveMoney(self):
        pass

    '''转账'''
    def transferMoney(self):
        pass

    '''改密'''
    def changePasswd(self):
        pass

    '''锁定'''
    def lockUser(self):
        pass

    '''解锁'''
    def unlockUser(self):
        pass

    '''补卡'''
    def newCard(self):
        pass

    '''销户'''
    def killUser(self):
        pass


    # 验证密码
    def checkPasswd(self, realPasswd):
        for i in range(3):
            tempPasswd = input("请输入密码：")
            if tempPasswd == realPasswd:
                return True
        return False

    # 随机生成卡号
    def randomCardId(self):
        while True:
            str = ""
            for i in range(6):
                ch  = chr(random.randrange(ord('0'), ord('9')+1))
                str += ch
            # 从字典中取出卡号，如果相同，则重新生成，如果不同则返回卡号
            if not self.allUsers.get(str):
                return str

    # 验证卡号是否存在
    def checkCard(self):
        cardNum = input("请输入你的卡号：")
        while True:
            user = self.allUsers.get(cardNum)
            if user:
                cardPasswd = input("请输入你的密码：")
                while True:
                    if cardPasswd == user.card.cardPasswd:
                        return user
                    else:
                        cardPasswd = input("密码错误！请重新输入：")
            else:
                cardNum = input("该卡号不存在！请重新输入你的卡号：")







































