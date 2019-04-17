"""
时间
"""
import time

# 返回当前程序的CPU执行时间
# Unix形同始终返回全部的运行时间
# Winodws从第一次开始，都是以第一个框调用此函数开始建戳为基数
# 这个可以做一个系统的性能测试
y1 = time.clock()
print(y1)

time.sleep(1)
y2 = time.clock()
print(y2)


time.sleep(2)
y3 = time.clock()
print("%d" % y3)

print("")

































