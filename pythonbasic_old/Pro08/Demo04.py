'''
测量对象引用的个数
'''
import sys

class T:
    pass

t1=T()
t2=t1
t3=t2

num=sys.getrefcount(t1)

print("当前的引用个数为：%d"%(num-1))



































