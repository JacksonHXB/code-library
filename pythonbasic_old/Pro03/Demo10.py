''' 名字管理系统 '''

#1，打印功能提示：
names=[]                                    #定义一个空的列表来存储添加的名字

while True:                                 #实现程序的重复执行
    print("*"*50)
    print("名字管理系统".center(40))
    print("-"*50)
    print("1：添加一个新的名字")
    print("2：删除一个名字")
    print("3：修改一个名字")
    print("4：查询一个名字")
    print("5：退出系统")
    print("*"*50)

#2，获取用户的选择
    num=int(input("请输入功能序号："))
    
#3，根据用户的选择执行相应的功能
    if num==1:
#       pass                                 #pass在这里忽略警告，在这里占坑
        newName=input("请输入一个名字：")
        names.append(newName)
    elif num==2:
        deleteName=input("请输入你删除的名字：")
        names.remove(deleteName)
    elif num==3:
        oldName=input("请输入你要修改的名字：")
        i=0
        while i<len(names):
            if names[i]==oldName:
                updateName=input("请输入新的名字：")
                names[i]=updateName
                break 
    elif num==4:
        findName=input("请输入你要查询的名字：")
        if findName in names:
            print("找到了你要找的人！")
        else:
            print("这里没有你要找的人！")
    elif num==5:
        break
    else:
        print("你的输入有误，请重新输入！")
    
    #打印这个列表
    print(names)





















