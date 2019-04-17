"""
    鼠标右击菜单
"""
import tkinter

win = tkinter.Tk()

win.geometry("400x400+200+100")

# 定义菜单栏
menubar = tkinter.Menu(win)

# 定义一级菜单
menu = tkinter.Menu(menubar, tearoff=False)

# 向一级菜单中添加二级菜单
for item in ["Java", "Python", "PHP", "C++"]:
    menu.add_command(label=item)

# 将一级菜单绑定到菜单栏上
menubar.add_cascade(label="语言", menu=menu)

def showMenu(event):
    # 在指定位置上显示右击菜单
    menubar.post(event.x_root, event.y_root)

# 给窗体绑定右击事件
win.bind("<Button-3>", showMenu)

win.mainloop()



























