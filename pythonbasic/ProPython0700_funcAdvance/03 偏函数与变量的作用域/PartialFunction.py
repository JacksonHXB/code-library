#===============================================================================
# 偏函数
#===============================================================================
# import module
import functools

# Convert to binary
print(int("1100", base = 2))

# Custom partial function
def int2(str, base = 2):
    return int(str, base)

print(int2("1001"))

# Automatic generate partial function
int3 = functools.partial(int, base = 2)

print(int3("1001"))


























