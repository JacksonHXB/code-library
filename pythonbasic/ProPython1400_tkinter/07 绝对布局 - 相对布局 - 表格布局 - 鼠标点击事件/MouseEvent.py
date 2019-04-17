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
import tkinter

win = tkinter.Tk()
win.geometry("400x400+200+100")

# 鼠标左键点击
button1 = tkinter.Label(win, text="LeftMouse button")
def func(event):
    # 输出鼠标在控件上的点击位置
    print(event.x, event.y)
# 绑定事件
button1.bind("<Button-1>", func)
'''
    event属性：
        char               从键盘输入和按键事件相关的字符
        keycode            从键盘输入的和按键事件相关的键的键代码（即统一码）
        keysym             从键盘输入的和按键相关的键的键符号
        num                按键数字（1， 2， 3）表明按下的是那个鼠标键
        widget             触发这个事件的小构建对象
        x和y               当前鼠标在小构件中以像素为单位的位置
        x_root和y_root     当前鼠标相对于屏幕左上角以像素为单位的位置        
'''

# 绑定鼠标进入控件时触发时的事件
button2 = tkinter.Button(win, text="RightMouse button")
button2.bind("<Enter>", func)





button1.pack()
button2.pack()
win.mainloop()











































