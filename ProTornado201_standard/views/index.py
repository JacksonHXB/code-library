#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("Jackson is a good man!")


class HomeHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("home")


























