"""
Tuple
"""
# Create an empty tuple.
tuple1 = ()
print(tuple1)

# Create a tuple with elements.
tuple2 = (1, 2, 3, "good", True)
print(tuple2)

# Get the element in tuple
tuple3 = (1, 2, 3, 5)
print(tuple3[0])

# Get the last element in tuple.
print(tuple3[-1])

# The tuple's element type can't be changed.
tuple4 = (1, 2, 3, [1, 2, 3])
tuple4[3][0] = 6
print(tuple4)

# Delete tuple
tuple6 = (1, 3, 3, 4)
del tuple6

# tuple's addition
t7 = (1, 2, 3)
t8 = (4, 5, 6)
print(t7 + t8)

# Tuple's multiplication
print(t8 * 3)

# Found element in tuple
t11 = (1, 2, 3)
print(1 in t11)

# Interception in tuple
t12 = (1, 2, 3, 4, 5, 6)
print(t12[3 : 5])
print(t12[: 2])

# tuple2D
t13 = ((1, 2, 3), (4, 5, 6), (7, 8, 9))
print(t13[1][2])

# len()
t14 = (1, 2, 3, 4, 5)
print("Numbers of tuple's element:", len(t14))

# Get the maximum of tuple
print(max(t14))

# Get the minimum of tuple
print(min(t14))

# Convert the list to the tuple
list = [1, 2, 3]
t15 = tuple(list)
print(t15)

# Foreach the tuple
for i in t15:
    print(i)






