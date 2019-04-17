#===============================================================================
# 字符串操作函数
#===============================================================================

# It's similar to int(str)
num1 = eval("123")
print(num1, type(num1))
print(eval("12 + 3"))


# Get the length of str
str = "abcdef"
print("Length is ", len(str))


str2 = 'esjifef'

# Converts uppercase letters in a string to lowercase
str = "JACKSON is a good man"
print("Uppercase convert to lowercase:", str2.lower())


# Converts lowercase letters in a string to uppercase.
print("Lowercase convert to uppercase:", str2.upper())


# Change uppercase to lowercase,lowercase to uppercase.
print("Converts to each others:", str2.swapcase())


# Capital letter is uppercase,other letters are lowercase.
print(str.capitalize())


# Capital letter in every word is uppercase.
print(str2.title())


# Converts to each others.
print(str2.swapcase())


# Characters in the middle
print(str2.center(60, "*"))
print(str2.center(40))

print(str2.ljust(40, "%"))
print(str.rjust(40, "%"))


# zfill(width)
str28 = "Jackson is a nice man"
print(str28.zfill(30))


# Get count of the some characters.
print(str28.count("i"))
print(str28.count("is", 0, len(str28)))


# Determine whether characters is in contained,return the index subscript firstly be found from left to right.
str30 = "Jackson is a smart man!";
print(str30.find("is"))
print("find:", str30.find("i", 0, len(str30)))
print(str30.rfind("is"))

# index()  rindex()
print(str30.index("is"))
print("rindex:", str30.rindex("i", 0, len(str30)))


str31 = "    space"
str32 = "****space"
print(str31.lstrip())
print(str32.lstrip("*"))

































