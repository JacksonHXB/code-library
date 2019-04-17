''' 
文件的复制 
'''
#1,获取用户要复制的文件名
oldFileName=input("请输入要复制的文件名：")
    #这里默认是打开是该项目下的文件

#2,打开要复制的文件
oldFile=open(oldFileName,"r")



position=oldFileName.rfind(".")
newFileName=oldFileName[0:position]+"[复件]"+oldFileName[position:]

#3,新建一个文件
newFile=open(newFileName,"w")

#4,从旧文件中读取数据，并且写入到新的文件中
content=oldFile.read()
newFile.write(content)

#5,关闭两个文件
oldFile.close()
newFile.close()















