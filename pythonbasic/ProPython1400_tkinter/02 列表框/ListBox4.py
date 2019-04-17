import tkinter

win = tkinter.Tk()
win.geometry("300x100+200+100")

# tkinter.MULTIPLE支持多选
listBox = tkinter.Listbox(win, selectmode=tkinter.MULTIPLE)

for item in ["good", "nice", "handsome", "cool", "good", "nice", "handsome", "cool"]:
    listBox.insert(tkinter.END, item)

listBox.pack()

win.mainloop()


























