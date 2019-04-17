#===============================================================================
# 随机数
#===============================================================================

# 导入随机数的库
import random

# 方法一
#------------------------------------------------------------------------------ 
# 从列表中随机取出一个值
print("Random1: ", random.choice([1, 3, "小兵", 7, 23.5]))

# 从一个范围内随机取出一个值 in [0,5)
print("Random1: ", random.choice(range(5)))

# 从字符中随机取出一个字母
print("Random1: ", random.choice("OperatorsAndExpressions - If"))

'''Generate a random number between 1 and 100'''
r1 = random.choice(range(100)) + 1
print("The result is: ", r1)


# 方式二
#------------------------------------------------------------------------------ 
# Generate random number by method2.
print("Random2: ", random.randrange(1, 100, 2))

# Generate random Integer number in range [0, 100). The step default value is 1.
print("Random2: ", random.randrange(100))

# Generate random Float number in range [0, 1)
print("Random2: ", random.random())


# 对一个列表进行随机排序
testList = [1, 2, 3, 4, 5]
# Sort all the elements of the sequence in random order.
random.huffle(testList)
print("Random3: ", testList)


# 随机生成一个实数
# Generate randomly a real number. It's in range [start, stop]
print("Random4: ", random.uniform(3, 9))
























