#===============================================================================
# 数学函数
#===============================================================================

# 导入数学函数库
import math

a1 = -10
a2 = 20
a3 = 40
# 返回一个数的绝对值
print("Absolute value :", abs(a1))

# 返回几个数中间的最大值
print("Maximum value :", max(a1, a2, a3))

# 返回几个数中间的最小值
print("Minimum value :", min(a1, a2, a3))

a4 = 2
a5 = 4

# 返回2的4次方的值
print("The a5-th power of a4 :", pow(a4, a5))

# 四舍五入
print("Rounding off 1 :", round(3.145))
print("Rounding off 2 :", round(3.145, 2))

# Round up
print("Round up :", math.ceil(18.1))

# Round down
print("Round down :", math.floor(18.9))

# 返回实数部分
print("Return the integer part and the fractional part:", math.modf(22.3))

# 开平方
print("Square root: ", math.sqrt(16))
































