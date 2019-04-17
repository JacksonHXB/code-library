"""
Set
"""

# 创建一个set集合
s1 = set([1, 2, 3, 4, 5, 4])
# If there is a common element, it will be strain.
print(s1)

s2 = set((1, 2, 3, 4, 3, 4))
print(s2)

s3 = set({1: "good", 2: "nice", 3: "beautiful"})
print(s3)


# Addition
s4 = set([1, 2, 3, 4, 5])
s4.add(6)
# s4.add([7, 8 9]) Because of the alterable list,It will not as a element
print(s4)

# update
s5 = set([1, 2, 3, 4])
s5.update([6, 7, 8])
print(s5)

# .remove()
s5.remove(7)
print(s5)

# Foreach
s7 = set([1, 2, 3])
for i in s7:
    print(i)

# Foreach2: The subscripts are not value
for index, data in enumerate(s7):
    print(index, data)


s8 = set([1, 2, 3])
s9 = set([2, 3, 4])
# Intersection
a1 = s8 & s9
print(a1, type(a1))
# Union
a2 = s8 | s9
print(a2, type(a2))

"""
    Transition of Set
"""
# list-->set
list1 = [1, 2, 3, 4, 5]
s1 = set(list1)

# tuple-->set
t2 = (1, 2, 3, 4, 5)
s2 = set(t2)

# dict-->set
d3 = {1: "test", 2: "done", 3: "ok"}
s3 = set(d3)

# set-->list
set3 = {1, 2, 3, 4}
print(list(set3))

# set-->tuple
print(tuple(set3))
























