"""
    表格数据
"""
import tkinter
from tkinter import ttk

win = tkinter.Tk()
win.geometry("600x400+200+100")

# 创建表格
table = ttk.Treeview(win)

# 申明列
table["columns"] = ("姓名", "年龄", "身高", "体重")

# 设置列
table.column("姓名", width=100)
table.column("年龄", width=100)
table.column("身高", width=100)
table.column("体重", width=100)

# 设置表头
table.heading("姓名", text="Name")
table.heading("年龄", text="Age")
table.heading("身高", text="Height")
table.heading("体重", text="Weight")

# 向表格中添加数据
table.insert("", 0, text="line1", values=("黄小兵", "23", "175", "120"))
table.insert("", 1, text="line2", values=("黄丽", "18", "160", "90"))
table.insert("", 2, text="line3", values=("朱波", "20", "167", "150"))

table.pack()

win.mainloop()





















































