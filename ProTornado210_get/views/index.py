#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("This is a test!")
        
#---  GET传参,方式一   ------------------------------------------------------------------------ 
class TransferHandler1(RequestHandler):
    def get(self, *args, **kwargs):
        a = self.get_query_argument("a")
        b = self.get_query_argument("b")
        c = self.get_query_argument("c")
        print(a + "-" + b + "-" + c)
        self.write("Jackson is a good man!")


#---  GET传参,方式二  ------------------------------------------------------------------------ 
class TransferHandler2(RequestHandler):
    def get(self, *args, **kwargs):
        alist = self.get_query_arguments("a")
        c = self.get_query_argument("c")
        print(str(alist) + "-" + c)
        self.write("Jackson is a nice man!")

























































































