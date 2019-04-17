"""
    点击按钮从一个输入框将值赋给另一个输入框
"""
import tkinter


win = tkinter.Tk()
win.geometry("500x500+420+100")

def showEntryInfo():
    e2.set(e1.get())

e1 = tkinter.Variable()
entry1 = tkinter.Entry(win, textvariable=e1)

e2 = tkinter.Variable()
entry2 = tkinter.Entry(win, textvariable=e2)

button = tkinter.Button(win, text="按钮", command=showEntryInfo)

entry1.pack()
button.pack()
entry2.pack()

win.mainloop()