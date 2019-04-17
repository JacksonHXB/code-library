'''
递归
'''
#4!=4*3*2*1
#5!=5*4*3*2*1

# i=1
# result=1
# while i<=4:
#     result=result*i
#     i+=1
# 
# print(result)

#5!=5*4!
#4!=4*3!
#3!=3*2!

def getNums(num):
    if num>1:
        return num*getNums(num-1)
    else:
        return num
print(getNums(4))






































