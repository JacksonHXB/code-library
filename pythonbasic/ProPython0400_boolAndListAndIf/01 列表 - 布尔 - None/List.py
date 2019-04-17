#===============================================================================
# 列表
#===============================================================================
# Traditional methods:
age1 = 18
age2 = 19
age3 = 20
age4 = 21
age5 = 22
print("Result:", ((age1 + age2 + age3 + age4 + age5) / 5))

# Create an empty list.
list1 = []
print(list1)

# Create a list with some elements.
list2 = [18, 19, 20, 21, 22]

# Create a list with some different type of elements.
list3 =[1, 2, "小兵", None, 4]

# Get the element in list.
print("Get the element in list:\n\t", list3[2])

# Replace the "小兵" to "xiaobing"
list3[2] = "xiaobing"
print("The result of replacement:\n\t", list3)

# Calculate the average of the age by List.
index = 0
sum = 0
while index < 5:
    sum += list2[index]
    index += 1
    if index == 5:
        print("The Average of age:%d" %(sum / 5))


def testList():
    test = [1,2,3,4,5,6]
    # 列表推导式
    [print(x) for x in test]
    # 输出返回的列表
    print([x-1 for x in test])



testList()















