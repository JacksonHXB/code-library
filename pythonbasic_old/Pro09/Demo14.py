'''
自定义异常
'''
def main():
    try:
        s=input('请输入—》')
        if len(s)<3:
            #raise引发一个自定义异常
            raise ShortInputException(len(s),3)
    except ShortInputException as result:#将变量绑定到错误的实例上去
        print('ShortInputException:输入的长度是：%d,长度至少是：%d'%(result.length,result))
    else:
        print('没有异常发生')

''' 自定义的异常类 ''' 
class ShortInputException(Exception):
    def __init__(self,length,atleast):
        self.length=length
        self.atleast=atleast
        
main()       
        
        
        
        
        
        
        
        
        
        
        
        
        
        