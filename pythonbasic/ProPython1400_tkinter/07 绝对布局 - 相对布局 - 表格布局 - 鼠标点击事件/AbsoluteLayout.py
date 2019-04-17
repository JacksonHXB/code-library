"""
    绝对布局
"""
import tkinter
from tkinter import ttk

win = tkinter.Tk()
win.geometry("600x400+200+100")

lab1 = tkinter.Label(win, text="good", bg="blue")
lab2 = tkinter.Label(win, text="handsome", bg="yellow")
lab3 = tkinter.Label(win, text="nice", bg="red")

# 绝对布局: 窗口的变化对控件的位置没有产生变化
lab1.place(x=10, y=10)
lab2.place(x=50, y=100)
lab3.place(x=100, y=200)

win.mainloop()






















































