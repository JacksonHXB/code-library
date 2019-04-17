'''判断星期几'''

day=int(input("请输入一个1~7的数："))

if day<1 or day>7:
    print("输入错误，请重新输入！")
elif day==1:
    print("今天是星期一！")
elif day==2:
    print("今天是星期二！")
elif day==3:
    print("今天是星期三!")
elif day==4:
    print("今天是星期四!")
elif day==5:
    print("今天是星期五!")
elif day==6:
    print("今天是星期六！")
else:
    print("今天是星期天！")

