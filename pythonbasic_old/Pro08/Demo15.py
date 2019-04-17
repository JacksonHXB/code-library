'''
类属性和实例属性:
    计算创建对象的个数
'''
class Tool(object):
    # 属性
    num = 0  # 类变量(全局变量)
    
    
    # 方法
    def __init__(self, name):
        self.name = name
        Tool.num+=1

tool1 = Tool("铁锹")
tool2 = Tool("工兵铲")
tool3 = Tool("水桶")
print(Tool.num)































