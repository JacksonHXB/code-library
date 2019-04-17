"""
Encode and Decode
"""
path = r"D:\Test.txt"

with open(path, "wb", encoding = "UTF-8") as f1:
    str = "Jackson is a good man!"
    f1.write(str.encode("UTF-8"))


with open(path, "rb") as f2:
    data = f2.read()
    print(type(data))
    # Decode
    newData = data.decode("UTF-8")
    print(type(newData))




























