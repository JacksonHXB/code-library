"""
Function of List
"""
# .append(value)
list1 = [1, 2, 3]
list1.append(6)
print(".append():\n\t", list1)
list1.append([4, 5, 6])
print(".append():\n\t", list1)


# .extend(value)
list2 = [1, 2, 3, 4]
list2.extend([6, 7, 8])
print(".extend():\n\t", list2)


# .insert(location, value)
list3 = [1, 2, 3]
list3.insert(1, 4)
print(".insert():\n\t", list3)


# .pop([location])
list4 = [1, 2, 3, 4, 5, 6]
num = list4.pop()
print(".pop()：\n\t", list4, num)
list4.pop(1)
print("pop()：\n\t", list4)


# .remove()
list5 = [1, 2, 3, 4, 5, "小兵", 6, "小兵"]
list5.remove("小兵")
print("remove():\n\t", list5)


# .clear()
list5.clear()
print("clear()：\n\t", list5)


# .index()
list6 = [1, 2, 3, 4, 5, "小兵"]
print("index()：\n\t", list6.index("小兵"))
print("index()：\n\t", list6.index("小兵", 0, 8))


# Get the length of list
print("len()：\n\t", len(list6))


# Get the maximum of the list
list7 = [1, 2, 4, 6, 5]
print("max()：\n\t", max(list7))


# Get the number of times it appears.
list8 = [1, 2, 4, 5, 7, 3, 3, 1, 4, 4]
print("count()：\n\t", list8.count(3))
'''
    Remove element 3 in the list
'''
size = list8.count(3)
num1 = 0
while num1 < size:
    list8.remove(3)
    num1 += 1
print(list8)


# reverse()
list9 = [1, 2, 3, 4, 5]
list9.reverse()
print("reverse():\n\t", list9)


# sort()
list10 = [2, 4, 12, 8, 10, 5]
list10.sort()
print("sort()：\n\t", list10)


# Shallow copy(reference copy)
list11 = [1, 2, 3, 4, 5]
list12 = list11
list11[1] = "test"
print("list11:", id(list11), "\tlist12:", id(list12))
print("\t", list11, list12)

# Deep copy
list13 = [1, 2, 3, 4, 5]
list14 = list13.copy()
list13[0] = "test"
print("list13:", id(list13), "\tlist14:", id(list14))
print("\t", list13, list14)


# list()
list15 = list((1, 2, 3, 4))
print("list()：\n\t", list15)












