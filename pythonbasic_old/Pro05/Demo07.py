''' 名字管理系统 '''

names=[]  

def print_menu():
    print("*"*50)
    print("名字管理系统".center(40))
    print("-"*50)
    print("1：添加一个新的名字")
    print("2：删除一个名字")
    print("3：修改一个名字")
    print("4：查询一个名字")
    print("5：退出系统")
    print("*"*50)  

def addNewPerson():
    ''' 这是用来定义添加对象的功能 '''
    newName=input("请输入一个名字：")
    global names
    names.append(newName)

def delPerson():
    ''' 这是用来删除名字的 '''
    deleteName=input("请输入你删除的名字：")
    global names
    names.remove(deleteName)
    
def updatePerson():
    ''' 这是用来更新名字的 '''
    global names
    oldName=input("请输入你要修改的名字：")
    i=0
    while i<len(names):
        if names[i]==oldName:
            updateName=input("请输入新的名字：")
            names[i]=updateName
            break 
    
def queryPerson():
    ''' 用来查询一个名片 '''
    global names
    findName=input("请输入你要查询的名字：")
    if findName in names:
        print("找到了你要找的人！")
    else:
        print("这里没有你要找的人！")

def main():
    global names
    
    print_menu()
    
    while True:
        num=int(input("请输入功能序号："))
        if num==1:
            addNewPerson()
        elif num==2:
            delPerson()
        elif num==3:
            updatePerson()
        elif num==4:
            queryPerson()
        elif num==5:
            break
        else:
            print("你的输入有误，请重新输入！")
    
        print(names)

''' 定义主函数 '''  
main()


