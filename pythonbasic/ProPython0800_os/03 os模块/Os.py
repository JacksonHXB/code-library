"""
OS
"""
import os

# Get the type of the operation system.
print(os.name)

# Get the information of the operation system's retails.
# print(os.uname())

# Get the environment variable of the system.
print(os.environ)

# Get the value of the path
print(os.environ.get("PATH"))

# Get the directory of the current location.
print(os.curdir)

# Get the directory of current working location.It's the location of the current python script.
print(os.getcwd())

# Get the list of the content at this location.
print(os.listdir(r"D:\python"))

# Create the new directory
os.mkdir("newDirectory")

# Delete the new directory
os.rmdir("newDirectory")

# Get the properties of the file.
print(os.stat("newDirectory"))

# Rename the file
os.rename("newDirectory", "newNewDirectory")

# Delete of the file
os.remove("demo.txt")

# Execute the shell command.
os.system("write")
# Close the program
os.system("taskkill /f /im notepad.exe")

# Get the absolute location.
print(os.path.abspath("./newDirectory"))

# Connect the two path.
p1 = r"D:\demo1\demo2"
p2 = r"test\abc\d"
print(os.path.join(p1, p2))

# Split the path to a tuple.
path2 = r"D:\demo1\demo2\demo3.txt"
print(os.path.split(path2))

# Get the extension name.
print(os.path.splitext(path2))

# Determine whether it is a directory.
print(os.path.isdir(path2))

# Determine whether file exists.
print(os.path.isfile(path2))

# Determine whether directory exists.
print(os.path.exists(path2))

# Get the size of the file.
print(os.path.getsize(path2))

# Get the directory of the file.
print(os.path.dirname(path2))

# Get the name of the file.
print(os.path.basename(path2))
















