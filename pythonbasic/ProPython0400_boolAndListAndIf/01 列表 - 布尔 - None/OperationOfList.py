"""
Operations of the List
"""

'''Combination of Lists
'''
list5 = [1, 2, 3]
list6 = [4, 5, 6, 7]
list7 = list5 + list6
print("Result of the combination:\n\t", list7)


'''Repetition of Lists
'''
list8 = [1, 2, 3]
list9 = list8 * 3
print("Result of the repetition:\n\t", list9)


''' Determine whether the element is in the list
'''
list10 = [1, 2, 3, 4, 5]
print("Result of determine whether the element is in the list:\n\t", (4 in list10))


'''Interception of List
'''
newList = list10[2 : 5]
print("Interception of List:\n\t", newList)
newList2 = list10[: 5]
print("Interception of List2:\n\t", newList2)


'''2DList
'''
list2D = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
# Get 5
num = list2D[1][1]
print("Result of list2D:\n\t", num)















































