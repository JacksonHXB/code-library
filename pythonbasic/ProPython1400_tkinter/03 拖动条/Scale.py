"""
    Scale控件
        供用户通过拖拽指示器改变变量的值，可以水平或者竖直

"""
import tkinter

win = tkinter.Tk()
win.geometry("300x300+200+100")

def showNum():
    print(scale1.get())

# 创建水平滚动条，
# 如果没有orient属性，默认就是垂直滚动条，tkinter.VERTICAL也表示水平; length水平时表示宽度，tickinterval表示间隔的刻度递增

scale1 = tkinter.Scale(win, from_=0, to=100, orient=tkinter.HORIZONTAL, tickinterval=10, length=200).pack()

scale2 = tkinter.Scale(win, from_=0, to=100).pack()

# 设置scale的值
scale1.set(20)

# 获取scale的值
print(scale1.get())

win.mainloop()























