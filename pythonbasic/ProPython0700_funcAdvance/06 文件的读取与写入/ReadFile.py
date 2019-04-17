"""
Read File
"""

# 1, Open the file.
path = r"D:\Test.txt"
file = open(path, "r", encoding = "UTF-8", errors = "ignore")

# 2, Read the file content.
# print(file.read())  Read all the file

# Read three characters.
# print(file.read(3))

# Read ten characters again.
# print(file.read(10))

# Read one line in the file.
# print(file.readline())

list7 = file.readlines()
print(list7)

# 3, Close the file.
file.close()

# Continue to read file.
# Update the descriptor
file.seek(10)
print(file.readline())
file.close()



"""Complete process1"""
try:
    f1 = open(path, "r", encoding = "UTF-8")
    print(f1.read())
finally:
    if f1:
        f1.close()


#------------------------------------------------------------------------------ 
'''使用with语句进行读取'''
with open(path, "r", encoding = "UTF-8") as f2:
    print(f2.read())



































