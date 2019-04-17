"""
    语音合成
"""
import win32com.client

dehua = win32com.client.Dispatch("SAPI.SPVOICE")

# 输出语音
dehua.Speak("Jackson is a good man!")
























