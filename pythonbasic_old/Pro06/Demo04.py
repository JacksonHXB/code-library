'''  
动态语言的特性
'''
def test(a,b,func):
    result=func(a,b)
    return result

func_new=input("请输入一个匿名函数")

#将字符串转换为python表达式
func_new=eval(func_new)


#用户自定义函数
num=test(11,22,func_new)
print(num)