"""
For
"""

for i in [1, 2, 3, 4, 5]:
    print(i)
print()

# range()
for x in range(3):
    print(x)
print()


# range()
for x in range(2, 20, 2):
    print(x)
print()


# Meanwhile, the subscripts and elements are traversed.
for index, m in enumerate([1, 2, 3, 4, 5]):
    print(index, ":", m)


# 1+2+3+..+100=?
sum = 0
for n in range(1, 101):
    sum += n
print(sum)
























