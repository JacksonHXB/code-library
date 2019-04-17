import win32con
import win32gui
import time

# Find the number of QQ window
QQWin = win32gui.FindWindow("TXGuiFoundation", "QQ")

# Hide the window
win32gui.ShowWindow(QQWin, win32con.SW_HIDE)

time.sleep(2)

# Show the window
win32gui.ShowWindow(QQWin, win32con.SW_SHOW)



























