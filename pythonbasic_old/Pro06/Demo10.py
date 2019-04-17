''' 
文件的读写练习
'''
''' 文件的写入操作 '''
file=open("test.txt","w")
file.write("测试")
file.close()

''' 文件的读取操作 '''
file2=open("test.txt")#python默认是以读的模式
content=file2.read()
print(content)




























