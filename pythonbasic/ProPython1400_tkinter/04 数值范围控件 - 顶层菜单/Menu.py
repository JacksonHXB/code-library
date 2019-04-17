"""
    Menu顶层菜单

"""
import tkinter

win = tkinter.Tk()
win.geometry("300x300+200+100")

def func():
    print("Jackson is a good man！")


# 定义菜单栏
menubar = tkinter.Menu(win)
# 配置菜单栏
win.config(menu=menubar)

# 给添加选项添加子菜单组
menu1 = tkinter.Menu(menubar, tearoff=False)
for item in ["Java", "Python", "C++", "PHP", "C#", "C#", "JS", "C", "NodeJs", "Swift", "EXIT"]:
    # 当点击退出时，就退出程序
    if item == "EXIT":
        # 添加分割符
        menu1.add_separator()
        menu1.add_command(label=item, command=win.quit)
    else:
        menu1.add_command(label=item, command=func)

# 给菜单栏添加菜单选项
menubar.add_cascade(label="语言", menu=menu1)

win.mainloop()























