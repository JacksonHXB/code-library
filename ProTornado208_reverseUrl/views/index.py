#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        # 不管配置的路由的正则怎么变，这里的链接地址都是这个
        # 设置反向解析
        url = self.reverse_url("demo")
        self.write("<a href='%s'>去另一个界面</a>"%(url))


#--- 反向解析 ------------------------------------------------------------------
class HxbHandler(RequestHandler):
    # 接收参数
    def initialize(self, param1, param2):
        self.param1 = param1;
        self.param2 = param2;
    def get(self, *args, **kwargs):
        print(self.param1, self.param2)






























































































