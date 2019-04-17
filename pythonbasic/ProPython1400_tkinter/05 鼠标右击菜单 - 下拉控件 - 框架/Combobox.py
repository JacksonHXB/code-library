"""
    Combobox下拉控件
"""
import tkinter
from tkinter import ttk

win = tkinter.Tk()
win.geometry("400x400+200+100")

# 设置变量用于绑定
cv = tkinter.StringVar()

# 创建下拉菜单
com = ttk.Combobox(win, textvariable=cv)

# 向下拉菜单中添加元素
com["value"] = ("四川", "上海", "杭州", "广州")

# 设置下拉菜单的默认值.current(index)
com.current(0)

# 绑定事件
def func(event):
    # 获取控件中选中的值
    print("获取方式1：" + com.get())
    print("获取方式2：" + cv.get())
com.bind("<<ComboboxSelected>>", func)









# 显示下拉菜单
com.pack()

win.mainloop()