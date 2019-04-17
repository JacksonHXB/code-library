#===============================================================================
# Keyword Parameter and Default Parameter
#===============================================================================



# 关键字参数
#------------------------------------------------------------------------------ 
def myPrint(name, age):
    print("My name is %s, and age is %d" % (name, age))
# Use keyword parameter
myPrint(age=18, name="Jackson")


#------------------------------------------------------------------------------ 
"""参数默认值"""
def myPrint2(name="Jackson", age=18):
    print(name, age)
myPrint2("Tom", 12)
myPrint2(name="Tom")
myPrint2()

# Attention: the sequence of parameter list.
def myPrint3(age, name="Jackson"):
    print(name, age)
myPrint3("12")


# 可变长度的参数
#------------------------------------------------------------------------------ 
# *arr will accept the residual parameter
def func(name, *args):
    print(name)
    for x in args:
        print(x)
func("小兵", "good", "nice", "handsome")

'''Calculate the sum of multiple parameters '''
def mySum(*num):
    sum = 0
    for i in num:
        sum += i
    return sum
print(mySum(1, 2, 3, 4, 5))
print(mySum(3, 4, 5))


'''Variable-length Parameter2'''
# **kwargs
def func2(**kwargs):
    print(kwargs)
    print(type(kwargs))
print(func2(x=1, y=2, z=3))


''' It can accept any type of parameter'''
def func3(*args, **kwargs):
    pass























