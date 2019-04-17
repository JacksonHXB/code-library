'''白富美升级版'''
yourSex=input("你的性别：")


if yourSex=="男":
    color=input("请问你白吗？")
    money=int(input("请问你的资产是多少？"))
    beautiful=input("请问你漂亮吗？")
    if color=="白" and money>=10000000 and beautiful=="美":
        print("她是一个白富美!")
    else:
        print("她是一个女屌丝！")
elif yourSex=="女":
    height=int(input("请问你多高？"))
    money=int(input("请问你的资产是多少？"))
    smart=input("你帅吗？")
    if height>=180 and money>=10000000 and smart=="帅":
        print("他是一个高富帅！")
    else:
        print("他是一个穷屌丝！")
