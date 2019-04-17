
file=open("Demo06.py")

content=file.readline()
content2=file.read(1024)

while True:
    content=file.read(1024)
    
    if len(content):
        break

print(content)






























