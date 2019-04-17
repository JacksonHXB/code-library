"""
tkinter简单小实例
"""

import tkinter

def func():
    print("Jackson is a good man!")


# 创建主窗口
win = tkinter.Tk()
# 设置窗口标题
win.title("测试窗口")
# 设置窗口大小和位置,500x500表示宽高，200表示距离屏幕左侧的距离，0表示距离屏幕顶部的距离
win.geometry("500x500+420+100")


# Label标签控件
# wraplength属性表示文本中多宽就进行换行,justify设置换行后的对齐方式,anchor表示对齐方式，n e s w center ne ns se sw默认是center
# width表示字符的个数，height表示字符的行数
label = tkinter.Label(win, text="标签", bg="blue", fg="red", font=("黑体", 16), width=6, height=1, wraplength=50, justify="left", anchor="w")
# 显示控件
label.pack()


# Button按钮
# command点击之后执行的函数；其余属性与label属性差不多
button1 = tkinter.Button(win, text="按钮", bg="red", fg="blue", command=func, width=6, height=1)
button2 = tkinter.Button(win, text="测试按钮", command=lambda:print("Jackson is a nice man!"))
button3 = tkinter.Button(win, text="退出按钮", command=win.quit)
button1.pack()
button2.pack()
button3.pack()


# Entry输入控件，用于显示简单的文本内容
# show属性可以有，表示输入内容的显示方式; textvariable表示绑定变量
e = tkinter.Variable()
entry1 = tkinter.Entry(win, show="*")
entry2 = tkinter.Entry(win, textvariable=e)
entry1.pack()
entry2.pack()
# 给输入框设置值和获取值的两种方式
e.set("Jackson is a good man!")
print(e.get())
print(entry2.get())



















# 启动窗口
win.mainloop()

















































































