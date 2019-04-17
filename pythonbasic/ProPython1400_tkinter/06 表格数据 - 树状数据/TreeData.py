"""
    树状数据
"""
import tkinter
from tkinter import ttk

win = tkinter.Tk()
win.geometry("600x400+200+100")

# 创建树状
tree = ttk.Treeview(win)

# 创建一级分支
treeF1 = tree.insert("", 0, "中国", text="China", values=("F1"))
treeF2 = tree.insert("", 1, "美国", text="America", values=("F2"))
treeF3 = tree.insert("", 2, "英国", text="England", values=("F3"))

# 向一级分支中创建二级分支
treeF1_1 = tree.insert(treeF1, 0, "四川", text="SiChuan", values=("F1_1"))
treeF1_2 = tree.insert(treeF1, 0, "上海", text="ShangHai", values=("F1_2"))
treeF1_3 = tree.insert(treeF1, 0, "浙江", text="ZheJiang", values=("F1_3"))

tree.pack()

win.mainloop()





















































