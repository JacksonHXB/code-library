def test(a,b=22,c=33):
    result=a+b+c
    print("result=%d"%result)

test(11)
test(33,c=44)
test(44)