"""
    鼠标事件

    事件                     描述
    <Bi-Motion>         当鼠标左键被按住在控件上且移动鼠标事发生
    <Button-i>          Button-1,Button-2,Button-3表明左键，中键和右键，当在控件上单击鼠标左键时，Tkinter会自动抓到鼠标指针的位置，ButtonPressed-i是Button-i的代名词
    <ButtonReleased-i>  当释放鼠标左键时事件发生
    <Double-Button-i>   当双击鼠标左键时事件发生
    <Enter>             当鼠标光标进入控件时发生
    <Key>               当单击一个键时事件发生
    <Leave>             当鼠标光标离开控件时发生
    <Return>            当单击Enter时事件发生，可以将键盘上任意键（A,B,C,,,）和一个事件绑定
    <Shift+A>           当单击shift+A时事件发生，可以将alt,shift,ctrl和其他任意键组合
    <Triple-Button-i>   当三次单击鼠标左键时事件发生
"""
"""按键事件"""
import tkinter

win = tkinter.Tk()
win.geometry("400x400+200+100")


label = tkinter.Label(win, text="Jackson is a good man!", bg="red")

# 设置焦点
label.focus_set()
label.pack()

def func(event):
    print(event.char)
    print(event.keycode)
label.bind("<Key>", func)
'''
    特殊的按键
    <Shift_L>
    <Shift_R>
    <F5>
    <BackSpace>
'''
# 绑定指定键事件
label.bind("a", func)

# 绑定组合键事件
label.bind("<Control-p>", func)


win.mainloop()











































