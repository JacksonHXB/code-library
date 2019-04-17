""""
Sound
"""
import win32com.client

MyComputer = win32com.client.Dispatch("SAPI.SPVOICE")

# Let the program to play the sound.
MyComputer.speak("Jackson is a good man!")


































