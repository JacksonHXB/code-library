"""
    写CSV文件
"""
import csv

# 向csv文件写入数据,不过默认时换一行
def writeCSV(path, data):
    with open(path, "w") as f:
        writer = csv.writer(f)
        for rowData in data:
            writer.writerow(rowData)




path = r"D:\Test\python_test2.csv"
data = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
writeCSV(path, data)





















