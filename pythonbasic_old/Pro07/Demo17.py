'''
烤地瓜
'''
class SweetPotato:
    
    def __init__(self):
        self.cookedString="生的"
        self.cookedLevel=0
    
    def __str__(self):
        return "地瓜 状态：%s(%d)"%(self.cookedString,self.cookedLevel)

    def cook(self,cookedTime):
        self.cookedLevel+=cookedTime
        
        if self.cookedLevel>=0 and self.cookedLevel<3:
            self.cookedString="生的"
        elif self.cookedLevel>=3 and self.cookedLevel<5:
            self.cookedString="半生不熟"
        elif self.cookedLevel>=5 and self.cookedLevel<8:
            self.cookedString="熟了"
        elif self.cookedLevel>8:
            self.cookedString="烤糊了"

#创建一个地瓜对象
diGua=SweetPotato()
print(diGua)
#开始烤地瓜
diGua.cook(1)
print(diGua)































