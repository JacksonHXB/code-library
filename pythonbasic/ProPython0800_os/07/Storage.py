"""
Process
"""
import win32process

# System
import win32con
import win32gui
import win32api
import ctypes

# Get the access
PROCESS_ALL_ACCESS = (0X000F0000 | 0X00100000 | 0XFFF)

# Find window
win = win32gui.FindWindow("MainWindow", "植物大战僵尸中文版")

# Find the number of process
hid, pid = win32process.GetWindowThreadProcessId(win)

# Open the process by the highest access
p = win32api.OpenProcess(PROCESS_ALL_ACCESS, False, pid)

# load the system inner module
md = ctypes.windll.LoadLibrary("C:\\Window\\System32\\kerne132")

data = ctypes.c_long()
# Read the storage.
md.ReadProcessMemory(int(p), 311944712, ctypes.byref(data))
print("data=", data)

# new value
newData = ctypes.c_long(10000)

# Update the storage.
md.WriteProcessMemory(int(p), 311944712, ctypes.byref(newData), 4, None)
























