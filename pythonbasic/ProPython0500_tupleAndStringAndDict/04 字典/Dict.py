"""
Dict
"""
dict1 = {"A1380" : 60, "B3245" : 50, "C4712" : 78}

# Get the value of dict,If there are no data in Dict, it will throw exception.
print(dict1["B3245"])

# .get(Key): If there are no data in Dict, it won't throw exception.
print(dict1.get("B3244"))

# insert new key-value to the dict.
dict1["D12343"] = 99
print(dict1)

# 更新某个键对应的值
dict1["A1380"] = 23
print(dict1)

# 删除某个键值
dict1.pop("D12343")
print(dict1)

# 遍历所有的key并获取相应的value
for key in dict1:
    print(key, dict1[key])

# 遍历所有的value
for  value in dict1.values():
    print(value)

# 遍历所有的key
for key in dict1.keys():
    print(key)

# 遍历所有的key,value
for key, value in dict1.items():
    print(key, value)

# Foreach the values with serial numbers.
for i, v in enumerate(dict1):
    print(i, v)
















































































