''' 名片管理系统 '''

print("*"*50)
print("名片管理系统".center(40))
print("1，添加一个新的名片")
print("2，删除一个名片")
print("3，修改一个名片")
print("4，查询一个名片")
print("5，显示所有")
print("6，退出系统")
print("*"*50)

users=[]

while True:
    #2,获取用户的输入
    num=int(input("请输入操作序号："))
    
    #3，根据用户的数据执行相应的功能
    #添加对象
    if num==1:
        newName=input("请输入新的名字：")
        newQQ=input("请输入新的QQ：")
        newWeixin=input("请输入新的微信：")
        newAddr=input("请输入新的地址：")
        
        #定义一个新的字典，用来存储一个新的名片
        newInfo={}
        newInfo["name"]=newName
        newInfo["qq"]=newQQ
        newInfo["weixin"]=newWeixin
        newInfo["addr"]=newAddr
        
        users.append(newInfo)
    elif num==2:
        userName=input("请输入你要删除的名字：")
        for temp in users:
            if userName==temp["name"]:
                users.remove(temp)
                print("删除成功!")
    elif num==3:
        updateName=input("请输入你要修改的姓名：")
        for temp in users:
            if updateName==temp["name"]:
                newName=input("请输入新的名字：")
                temp["name"]=newName
                print("修改成功！")
                break
    #查询用户
    elif num==4:
        flag=0 #默认表示没有找到
        
        target=input("请输入要查找的姓名：")
        print("姓名\tQQ\t微信\t住址")
        for temp in users:
            if target==temp["name"]:
                print("%s\t%s\t%s\t%s"%(temp["name"],temp["qq"],temp["weixin"],temp["addr"]))
                flag=1
                break
        if flag==0:
            print("查无此人！")
    #显示所有        
    elif num==5:       
        print("姓名\tQQ\t微信\t住址")
        for temp in users:
            print("%s\t%s\t%s\t%s"%(temp["name"],temp["qq"],temp["weixin"],temp["addr"]))
    #退出系统
    elif num==6:
        break
    else:
        print("输入有误，请重新输入！")
    print("")#换行
    









































