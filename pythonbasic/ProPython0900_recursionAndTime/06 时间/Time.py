"""
时间
"""
import time

# 返回当前的时间戳，浮点数形式，不需要参数
c = time.time()
print(c)

# 将时间戳转为UTC时间元组
t = time.gmtime(c)
print(t)

# 将时间戳转为本地时间元组
b = time.localtime(c)
print(time.localtime(c))

# 将本地时间元组转成时间戳
print(time.mktime(b))

# 将时间元组转换成字符串
print(time.asctime(b))

# 将时间戳转换成字符串
print(time.ctime(c))

# 格式化时间,参数2为时间元组，如果没有参数2，默认转换的是当前时间
q = time.strftime("%Y-%m-%d %H:%M:%S")
print(q)

# 将时间字符串转为时间元组
w = time.strptime(q, "%Y-%m-%d %X")
print(w)

# 时间延迟,这里给整数或者浮点数
time.sleep(2)




































































