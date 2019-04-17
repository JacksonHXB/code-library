"""
    Listbox列表框控件2
"""
import tkinter

win = tkinter.Tk()
win.geometry("400x400+200+100")

# 设置绑定的变量
listBoxVar = tkinter.StringVar()

# 与BROWSE相似，但是不支持鼠标拖动选中
listBox = tkinter.Listbox(win, selectmode=tkinter.SINGLE, listvariable=listBoxVar)

for item in ["A", "B", "C", "D"]:
    listBox.insert(tkinter.END, item)

# 获取listbox中的选项
print(listBoxVar.get())

# 更改列表中的选项
listBoxVar.set(("1", "2", "3"))

# 绑定事件,Double表示双击，Button表示按钮，1表示鼠标左键
# 这个函数需要参数，可以不调用
def myPrint(event):
    print(listBox.get(listBox.curselection()))
listBox.bind("<Double-Button-1>", myPrint)


listBox.pack()

win.mainloop()












































