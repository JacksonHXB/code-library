"""
Iterator
"""
from collections import Iterable
from collections import Iterator

# Judge that the list is a iterable object.
print(isinstance([], Iterable))

# Judge that the tuple is a iterable object.
print(isinstance((), Iterable))

# Judge that the dict is a iterable object.
print(isinstance({}, Iterable))

# Judge that the string is a iterable object.
print(isinstance("", Iterable))

# Judge that the number is a iterable object.
print(isinstance(5, Iterable))

print((x for x in range(10)), Iterable)


# Return a iterator
list2 = [1, 2, 3, 4, 5]
item = (x for x in list2)
print(next(item))
print(next(item))
print(next(item))

# Convert a list to iterator
a = iter(list2)
print(next(a))
print(next(a))
print(next(a))


# Input some codes constantly.When input "end",then it's end.
endstr = "end"
str = ""
for line in iter(input, endstr):
    str += line + "\n"
print(str)































