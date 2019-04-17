infos={"name":"黄小兵","age":18}

#len的用法
print("字典的长度：%s"%len(infos))

#获得键的列表
keysList=infos.keys()
print("键的列表为：%s"%keysList)

#获得某键的值
valueInfo=infos.get("name")
print("name是:%s"%valueInfo)

#获得值的列表
valuesList=infos.values()
print("值的列表是：%s"%valuesList)

#遍历1
for temp in infos.keys():
    print(temp)

#遍历2
for temp in infos.values():
    print(temp)

#遍历3
for temp in infos.items():
    print("key=%s,value=%s"%(temp[0],temp[1]))

#遍历4
for A,B in infos.items():
    print("key=%s,value=%s"%(A,B))













































