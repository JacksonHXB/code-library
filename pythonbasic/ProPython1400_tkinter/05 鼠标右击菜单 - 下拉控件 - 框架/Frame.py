"""
    Frame框架控件
        在屏幕上显示一个矩形区域，多作为容器控件使用
"""
"""
    鼠标右击菜单
"""
import tkinter

win = tkinter.Tk()
win.geometry("400x400+200+100")

# 左侧框架
frm_l = tkinter.Frame(win)
tkinter.Label(frm_l, text="左上", bg="pink").pack(side=tkinter.TOP)
tkinter.Label(frm_l, text="左下", bg="blue").pack(side=tkinter.TOP)
frm_l.pack(side=tkinter.LEFT)

# 右侧框架
frm_r = tkinter.Frame(win)
tkinter.Label(frm_r, text="右上", bg="red").pack(side=tkinter.TOP)
tkinter.Label(frm_r, text="右下", bg="yellow").pack(side=tkinter.TOP)
frm_r.pack(side=tkinter.RIGHT)


win.mainloop()






























































