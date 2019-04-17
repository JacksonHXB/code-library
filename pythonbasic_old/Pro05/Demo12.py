def num_2_nums(a,b,*args):
    #*args表示不定长的参数，输出的参数是一个字典
    print(a)
    print(b)
    print(args) 
    
num_2_nums(11,22,23,34,55,66,77)
print()
num_2_nums(11,22,33)
print()
num_2_nums(11,22)

