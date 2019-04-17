'''
文件的读写操作
'''
#打开文件
file=open("demo01.py")

#读取文件内容
#content=file.read()

#从当前文件开头向后移动2个字节
file.seek(2,0)

content=file.read()

#打印读取的文件
print(content)




































