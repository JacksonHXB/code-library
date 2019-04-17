"""
    卡类
"""
class Card(object):
    def __init__(self, cardId, cardPasswd, cardMoney):
        self.cardId = cardId            # 卡Id
        self.cardPasswd = cardPasswd    # 卡密码
        self.cardMoney = cardMoney      # 卡的金额
