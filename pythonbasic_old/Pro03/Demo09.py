names=["小王","小丽","小黄","小丽"]

#增加一个元素
names.append("悟空1")
print(names)
print()

#将一个元素插入到指定位置上
names.insert(1,"悟空2")
print(names)

names2=["葫芦娃","叮当猫","猴子"]
#将两个列表相加也可以用加号表示
# names2=names2+names
names2.extend(names)
print(names2)

#列表的最后两个元素删除
names2.pop()
names2.pop()
print(names2)

#删除小黄
names2.remove("小黄")
print(names2)

#删除指定下标的元素
del names2[0]
print(names2)

#将第一个元素改为黄小兵
names2[0]="黄小兵"
print(names2)

#查询
if "黄小兵" in names2:
    print("names2中含有'黄小兵'")
if "黄小兵" not in names:
    print("names中不含有'黄小兵'")













