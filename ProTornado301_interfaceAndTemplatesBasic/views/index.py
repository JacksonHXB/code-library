#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def initialize(self):
        print("initialize")
    
    def prepare(self):
        print("prepare")
    
    def get(self,*args,**kwargs):
        self.write("This is a test!")
        
    def set_default_headers(self):    
        print("set_default_headers")
    
    def write_error(self, status_code, **kwargs):
        print("write_error")
    
    def on_finish(self):
        print("on_finish")


#------ 渲染:传递参数---------------------------------
class HomeHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 传递数值
        temp = 100
        # 传递字典
        per= {
            "name":"Jackson",
            "age":18
        }
        # 列表
        stus = [
            {
                "name":"小兵",
                "age":21
            },
            {
                "name":"小丽",
                "age":13
            }
        ]
        # **per相当于把per字典中的参数传过去，而不是传递的是per这个对象
        self.render("home.html", num = temp, param=per, stus=stus, **per)


        




































































