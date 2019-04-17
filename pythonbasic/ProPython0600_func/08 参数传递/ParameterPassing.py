"""
ParameterPassing
"""
# Pass by value.
def func1(num):
    num = 10
temp = 20
func1(temp)
print(temp)


# Pass by quote.
def func2(lis):
    lis[0] = 100
li = [1, 2, 4, 4, 5]
func2(li)
print(li)




























