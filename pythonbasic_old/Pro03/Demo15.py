nums=[11,22,33,44]

#for..else的用法：如果for中途跳出，else里面的内容将会被执行
for temp in nums:
    print(temp)
    if temp==33:
        break
else:
    print("如果中途跳出，else将不会被执行！")