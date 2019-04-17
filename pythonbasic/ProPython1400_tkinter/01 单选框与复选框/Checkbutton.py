"""
    复选框
"""
import tkinter

win = tkinter.Tk()
win.geometry("500x170+200+100")

def updata():
    message = ""
    if hobby1.get() == True:
        message += "money\n"
    if hobby2.get() == True:
        message += "power\n"
    if hobby3.get() == True:
        message += "person\n"

    # 清除text中的所有内容
    text.delete(0.0, tkinter.END)
    text.insert(tkinter.INSERT, message)

hobby1 = tkinter.BooleanVar()
hobby2 = tkinter.BooleanVar()
hobby3 = tkinter.BooleanVar()

# 创建复选按钮
check1 = tkinter.Checkbutton(win, text="money", variable=hobby1, command=updata)
check2 = tkinter.Checkbutton(win, text="power", variable=hobby2, command=updata)
check3 = tkinter.Checkbutton(win, text="person", variable=hobby3, command=updata)
text = tkinter.Text(win, width=300, height=5)

check1.pack()
check2.pack()
check3.pack()
text.pack()

win.mainloop()













































