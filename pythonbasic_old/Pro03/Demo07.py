str="wer gfdsdvbnbf"

print("从左边开始寻找这个字符串：%d"%str.find("fds"))
print("从右边开始寻找这个字符串：%d"%str.rfind("fds"))
print("该字符串出现的次数：%d"%str.count("fds"))
print("将fds替换成FDS：%s"%str.replace("fds","FDS"))
print("将str的第一个字符大写：%s"%str.capitalize())
print("将str的每一个单词的第一个字母大写：%s"%str.title())

str2="lao wang"
print("判断字符串是否是以lao开头的：%s"%str2.startswith("lao"))
print("判断字符串是否以wang结尾的：%s"%str2.endswith("wang"))
print("将小写字母转为大写字母：%s"%str2.upper())
str2=str2.upper()
print(str2)
print("将大写字母转为小写字母：%s"%str2.lower())
print("居中对齐:%s"%str2.center(50))
str2=str2.center(50)
print("将字符串左边的空格去掉：%s"%str2.lstrip())

str3="hellow world\nI miss you\nBye"
print("以\n进行切割：%s"%str3.splitlines())
print("判断是否含有字母和数字：%s"%str3.isalnum())

str5="-"
str4=["h","ell","o"]
print("连接列表元素形成字符串：%s"%str5.join(str4))

test="qwertyj \tkgf dsa dfg \thj kj\t hgfds"
print("去掉\t和空格：%s"%test.split())
test=test.split()
print("还原成字符串：%s"%("".join(test)))






