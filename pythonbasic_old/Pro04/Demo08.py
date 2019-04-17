def test():
    a=11
    b=22
    c=33
    d=[a,b,c]
#   return d
    return a,b,c
# 返回多个值的时候，这里默认返回的是一个元组  
    
num=test()
print(num)