#===============================================================================
# 通用装饰器
#===============================================================================

def outer(func):
    # Get all kinds of parameters.
    def inner(*args, **kwargs):

        # Add the updated action
        print("$%^#$%^%$%^")

        func(*args, **kwargs)
    return inner

@outer
def say(name, age):
    print("my name is %s, I am %d years old" % (name, age))

say("小兵", 20)
















































