"""
Exception - Assertion
"""

# Attention1: It will appear some mistakes because of the order of exception.
'''
try:
    print(5 / 0)
except BaseException as e:
    print("exception1")
except ZeroDivisionError as e:
    print("exception2")
'''



# Attention2: Call across multiple layers.
def func1(num):
    print(1 / num)

def func2(num):
    func1(num)

def main():
    func2(0)

try:
    main()
except ZeroDivisionError as e:
    print("Warnings: there is a mistake")




'''try...except...finally'''
try:
    print(1 / 0)
except NameError as e:
    print("出现错误了！")
finally:
    print("必须执行！")

































