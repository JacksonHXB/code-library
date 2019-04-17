'''
验证内存的存储方式
'''
a=100

b=a

id(a)
print("a指向的地址是：%s"%(id(a)))
print("b指向的地址是：%s"%(id(b)))

