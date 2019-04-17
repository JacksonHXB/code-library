'''
def get_wendu():
    wendu=3
    return wendu
def print_wendu(wendu):
    print("温度是：%d"%wendu);
result=get_wendu()
print_wendu(result)
'''
wendu=0

def get_wendu():
#     如果wendu这个变量已经在全局变量的位置定义了，此时还想在函数中对这个全局变量进行
#     修改的话，仅仅只是赋予一个值，这还不够，此时wendu这变量是一个局部变量，仅仅是和全局变量的名字相同

#     是哦那个global用来对一个全局变量的声明，那么这个函数中的wendu=33就不是定义一个局部变量
    global wendu
    wendu=33
def print_wendu():
    print("温度是%d"%wendu)
get_wendu()
print_wendu()




















