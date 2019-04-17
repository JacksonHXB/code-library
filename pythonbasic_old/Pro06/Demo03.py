#匿名函数当作实参应用
def test(a,b,func):
    result=func(a,b)
    return result

num=test(11,22,lambda x,y:x+y)

#定义匿名函数，当test传入值的时候，函数test被调用并将11，22，匿名函数的引用分别指向a,b,func
#当调用func即是调用lambda，并将a，b传输，最后得到result

print(num)


































