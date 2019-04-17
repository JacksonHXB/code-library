#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("This is a test!")
#--- HTTP提取url特定部分 ------------------------------------------------------------------
class SpliteUrlHandler1(RequestHandler):
    def get(self, h1, h2, h3, *args, **kwargs):
        print(h1 + "-" + h2 + "-" + h3)
        
        
#--- HTTP提取url特定部分，方式二------------------------------------------------------------------
class SpliteUrlHandler2(RequestHandler):
    def get(self, p1, p2, p3, *args, **kwargs):
        print(p1 + "-" + p2 + "-" + p3)

























































































