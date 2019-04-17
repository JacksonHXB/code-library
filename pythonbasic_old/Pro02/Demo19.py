''' continue的用法 '''
i=1

while i<=10:
    i+=1
    
    print("-",end="")
    
    if i==3:
        continue
    
    print(" %d"%i,end="")
    