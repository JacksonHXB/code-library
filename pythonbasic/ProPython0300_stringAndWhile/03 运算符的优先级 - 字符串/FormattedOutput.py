"""
Formatted Output
"""
str = "Jackson is a good man!"
print(str)

age = 23
print("age =", age)
print("age = %d" % (age))

print("Result:%s" % (str))

# Exactly three decimal places.
score = 1.2
print("Result2:%f" % (score))
print("Result3:%.3f" % (score))

'''
    \n  define line break
    \t  tabs
'''
# Wrap the output
num = 12
str19 = "String"
f = 0.53
print("num = %d\nstr19 = %s\nf=%.3f" % (num, str19, f))

# show the line break
print("sunck \\n is")

# Output single quotation marks.
print('Tom is a \'good\' man')

# Output double quotation marks.
print("Tom is a \"good\" man")

# Constantly output multiple lines.
print('''
    good
    nice
    handsome
''')

# Ouput the tabs
print("sunck\tgood")

# Output multipile many line break.
print(r"\\\t\\")




















