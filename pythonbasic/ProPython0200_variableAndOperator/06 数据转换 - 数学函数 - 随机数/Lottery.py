"""
随机数
"""
import random

# 接收用户输入的数据
num = int(input("Please enter your number:"))

# 生成一个随机数
res = random.choice(range(100)) + 1

# 确定用户的号码是否等于随机数
if res == num:
    print("Congratulation!")
else:
    print("I'm sorry! You guessed wrong!")




































