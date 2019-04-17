"""
Function of String
"""
# .split()
str = "Jackson&is&a&good&man&!"
print(str.split("&"))
list9 = str.split("&")
print(list9)
print(str.split("&", 3))


# Get the number of the word
c = 0
for s in list9:
    if len(s) > 0:
        c += 1
print(c)


# .splitlines()
str2 = '''Jackson is a good man!
HXB is a good man!
CZS is a good man!
'''
print(str2.splitlines())
# show the '\n'
print(str2.splitlines(True))


# Convert the list to the string
list1 = ["a", "b", "c", "d"]
str3 = "%".join(list1)
print(str3)


# max() min()
print(max(str))
print(min(str))


# .replace()
str4 = "Jackson is a good man!"
str5 = str4.replace("is", "was")
print(str5)
str6 = str4.replace("o", "$", 2)
print(str6)


# .maketrans()
str7 = "Jackson is a good man!"
str8 = str7.maketrans("good", "nice")
str9 = "good nice beautiful smart kawayi"
str10 = str9.translate(str8)
print(str10)


# .startswith()
str11 = "Jackson is a good man!"
print(str11.startswith("Jackson"))
print(str11.startswith("Jackson", 2, 10))

# .endswith()
str12 = "Jackson is a good man!"
print(str12.endswith("!"))


# .encode()
str13 = "我是黄小兵!"
data = str13.encode("utf-8")
print(data)

# .decode()
str14 = data.decode("utf-8")
print(str14)

# .isalpha()
str15 = "Jackson is a good man!"
print(str.isalpha())

# .isalnum()
str16 = "12ab4c5"
print(str16.isalnum())

# .isupper()
print("ABCDEFGHIJKLMNOPQRSTUVWXYZ".isupper())
print("ABCD9".isupper())

# islower()
print("acbc1".islower())

# .istitle()
print("Sunck Is".istitle())

# .isdigit()
print("123".isdigit())

# .isnumeric()
print("123".isnumeric())

# .isdecimal()
print("123z".isdecimal())

# .isspace()
print("   ".isspace())
print("\n".isspace())
print("\r".isspace())
































