import win32con
import win32gui

# Find the number of QQ window
QQWin = win32gui.FindWindow("TXGuiFoundation", "QQ")

win32gui.SetWindowPos(QQWin, win32con.HWND_TOPMOST, 100, 100, 300, 300, win32con.SWP_SHOWWINDOW)
'''
    param1: Controlled window
    param2: window location
    param3: window location x
    param4: window location y
    param5: window width
    param6: window height
'''













































