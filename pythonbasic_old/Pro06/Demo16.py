'''
批量重命名
'''
import os

#1,获取要重命名的文件夹名字
folderName=input("请输入要重命名的文件夹")

#2，获取指定文件夹中的所有文件名字
fileNames=os.listdir(folderName)

os.chdir(folderName)

#3，重命名
for name in fileNames:
    oldFileName=folderName+"/"+name
    newFileName=folderName+"/"+name
    os.rename(oldFileName,"newName"+newFileName)



































