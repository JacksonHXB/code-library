"""
Write File
"""
import time

path = r"D:\Test.txt"
file = open(path, "w")

# Write File to the buffer area.
file.write("HuangXiaobing is a good man!")


time.sleep(1)

# 刷新缓冲区，并立即写入文件
file.flush()


file.close()




























