''' 剪刀石头布 '''

#导入产生随机数的工具箱
import random  

#提示并获取用户的输入
player=int(input("请输入：剪刀(0) 石头(1) 布(2)\n"))

#让电脑自动出一个
computer=random.randint(0,2)

#判断用户的输入，然后显示对应的结果
if (player==0 and computer==2) or (player==1 and computer==0) or (player==2 and computer==1):
    print("你赢了，，可以去买奶粉！")
elif player==computer:
    print("平局")
else:
    print("你输了，，重写再来!")



        
    































