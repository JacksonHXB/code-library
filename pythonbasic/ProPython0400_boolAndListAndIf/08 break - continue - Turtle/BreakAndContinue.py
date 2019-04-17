"""
Break
"""
num = 1
while num <= 5:
    # when the value of num is 3,It will jump out of the while loop
    if num == 3:
        break
    print(num)
    num += 1
else:
    print("The statement won't be executed forever.")
print()


"""
Continue
"""
num = 1
while num <= 5:
    if num == 3:
        continue
    print(num)
    num += 1






















