i=1

while i<=5:
    j=1
    while j<=i:
        print("*",end="")
        j+=1
        #跳出本次循环，跳出的是较近的一个循环
        break
    print("")
    i+=1

