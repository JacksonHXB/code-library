''' 打印1~100中间的20个偶数 '''

# 方法一：
# i=1
# num=1
# while i<=100:
#     if num<=20:
#         if i%2==0:
#             print(i)
#             num+=1
#     i+=1

# 方法二：
i=1
num=0
while i<=100:
    if i%2==0:
        print(i)
        num+=1
    if num==20:
        break
    i+=1
    
    
    























