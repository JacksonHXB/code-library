"""
Exception - Assertion
"""
try:
    print(3 / 0)
except ZeroDivisionError as e:
    print("除数为0了！")
except NameError as c:
    print("没有该变量")
else:
    # If the codes are right, the statement will be executed.
    print("代码没有问题！")
print("test")



try:
    print(4 / 0)
# Matches all exception types.
except:
    print("程序出现了异常！")
print("**********************")



# Using except with multiple exceptions.
try:
    pass
except (NameError, ZeroDivisionError):
    print("Multiple exception")














































