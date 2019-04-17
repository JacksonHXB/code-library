"""
    相对布局
"""
import tkinter
from tkinter import ttk

win = tkinter.Tk()
win.geometry("600x400+200+100")

lab1 = tkinter.Label(win, text="good", bg="blue")
lab2 = tkinter.Label(win, text="handsome", bg="yellow")
lab3 = tkinter.Label(win, text="nice", bg="red")

# 相对布局: 窗体尺寸改变会对控件产生影响
# tkinter.Y .X .BOTH
lab1.pack(side=tkinter.LEFT, fill=tkinter.Y)
lab2.pack(side=tkinter.TOP, fill=tkinter.X)
lab3.pack()

win.mainloop()






















































