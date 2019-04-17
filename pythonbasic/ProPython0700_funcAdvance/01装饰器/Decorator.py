#===============================================================================
# 装饰器
#===============================================================================

#------------------------------------------------------------------------------ 
"""简单装饰器"""
def func1():
    print("Jackson is a good man!")
    
def outer(func):
    # Turn func into inner()
    def inner():
        print("*****************")
        func()  # 如果在函数体内没有调用原函数，在附加函数后，将不会执行原函数中的内容
    return inner
# F is the enhanced version of func1
f = outer(func1)
f()


#------------------------------------------------------------------------------ 
'''复杂装饰器'''
def outer2(func):
    def inner(age):
        if age < 0:
            age = 0
        func(age)
    return inner
# When using the annotations, notice the order of functions.
@outer2
def say(age):
    print("Jackson is %d years old!" % (age))

# If using annotations, you don't need to write this sentence.
# say = outer(say)

say(-10)




































