"""
    Excel表格的读取
"""
import csv

def readCSV(path):
    infoList = []

    with open(path, "r") as f:
        # 从CSV中读取文件的全部内容
        allFileInfo = csv.reader(f)
        # 遍历出的每一行添加进列表中
        for row in allFileInfo:
            infoList.append(row)
    return infoList


path = readCSV(r"D:\Test\test.csv")
infoList = readCSV(path)
# 遍历列表文件
for i in infoList:
    print(i)
































































































