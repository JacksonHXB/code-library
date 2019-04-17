"""
While Expression
"""

# initialize the variable
num = 1
while num <= 5:
    # Output the value of num.
    print(num)
    # The num add one per cycle.
    num += 1


'''
    Calculate 1+2+3+...+100=?
'''
x = 1
sum = 0
while x <= 100:
    sum += x
    x += 1
print("sum:", sum)


'''
    Foreach the string
'''
str = "Jackson is a good man"
index = 0
while index < len(str):
    print("str[%d] = %s" % (index, str[index]))
    index += 1


'''
    Conversion between ASCII and String.
'''
str2 = "a"
# Convert str2 to ASCII
print(ord(str2))
# Convert ascii to String
print(chr(65))

































