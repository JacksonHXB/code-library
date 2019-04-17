'''
异常：
'''
try:
    num=11/0
    open("xxx.txt")
    print("-------1--------")
except (NameError,FileNotFoundError):
    print("出现异常，并进行了处理...")
except Exception as ret:
    print("如果用了Exception，那么意味着只要上面的except没有捕获到异常，这个一定会捕获到")
    print("异常是：%s"%ret) 
else:
    print("没有异常才会执行的功能！")   
finally:
    print("不管是否有异常，都会执行！")
    
print("------2----------")

















































