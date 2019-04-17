def test(a,b,c=33,*args,**kwargs):
    print(a)
    print(b)
    print(c)
    print(args)
    print(kwargs)

test(11,22,44,55,66,77,task=99,done=90)
''' 
分析：
    11，22分别传入指定的a，b中
    44是第三个参数存在，覆盖掉c的默认值33，因此是44
    55，66，77为多余的参数，分别传入*args中
    task=99,done=90带有参数名，分别传入到**kwargs
'''