"""
    表格布局
"""
import tkinter
from tkinter import ttk

win = tkinter.Tk()
win.geometry("600x400+200+100")

lab1 = tkinter.Label(win, text="good", bg="blue")
lab2 = tkinter.Label(win, text="handsome", bg="yellow")
lab3 = tkinter.Label(win, text="nice", bg="red")
lab4 = tkinter.Label(win, text="cool", bg="green")

# 表格布局
lab1.grid(row=0, column=0)
lab2.grid(row=0, column=1)
lab3.grid(row=1, column=0)
lab4.grid(row=1, column=1)

win.mainloop()

