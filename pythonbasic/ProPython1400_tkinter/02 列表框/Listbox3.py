import tkinter

win = tkinter.Tk()
win.geometry("300x100+200+100")


# tkinter.EXTENDED可以使listbox支持shift和ctrl键的使用
listBox = tkinter.Listbox(win, selectmode=tkinter.EXTENDED)

for item in ["good", "nice", "handsome", "cool", "good", "nice", "handsome", "cool"]:
    listBox.insert(tkinter.END, item)

# 滚动条
sc = tkinter.Scrollbar(win)

listBox.configure(yscrollcommand=sc.set)

sc['command'] = listBox.yview

sc.pack(side=tkinter.RIGHT, fill=tkinter.Y)

listBox.pack(side=tkinter.LEFT, fill=tkinter.BOTH)

win.mainloop()


























