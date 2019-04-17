"""
    单选按钮
"""
import tkinter

win = tkinter.Tk()
win.geometry("500x170+200+100")

def updata():
    print(r.get())

r = tkinter.IntVar()

radio1 = tkinter.Radiobutton(win, text="one", value=1, variable=r, command=updata)
radio2 = tkinter.Radiobutton(win, text="two", value=2, variable=r, command=updata)
radio3 = tkinter.Radiobutton(win, text="three", value=3, variable=r, command=updata)

radio1.pack()
radio2.pack()
radio3.pack()


win.mainloop()
