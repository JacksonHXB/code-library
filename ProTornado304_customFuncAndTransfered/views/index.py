#===============================================================================
# 视图
#===============================================================================

from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.render("home.html")
    
    
#--- 自定义函数 --------------------------------------
class FuncHandler(RequestHandler):
    def get(self, *args, **kwargs):
        def mySum(n1, n2):
            return n1 + n2
        self.render("home.html", mySum=mySum)


#---- 转义 --------------------------------------------
class TransHandler(RequestHandler):
    def get(self, *args,**kwargs):
        str = "<h1>Jackson is a good man!</h1>"
        self.render("trans.html", str=str)


































































