"""
    Spainbox数值范围控件

"""
import tkinter

win = tkinter.Tk()
win.geometry("300x300+200+100")

# 绑定事件
def updata():
    print(v.get())

# 绑定变量
v = tkinter.StringVar()

# increment表示步长，没有该属性默认为1
sp = tkinter.Spinbox(win, from_=0, to=100, increment=10, textvariable=v, command=updata)

# values属性最好不用from_to和increment属性同时使用
tkinter.Spinbox(win, values=(0, 2, 4, 6, 8)).pack()

# 给数值范围控件赋予默认值
v.set(20)

# 从数值范围控件中获取值
print(v.get())

sp.pack()

win.mainloop()























