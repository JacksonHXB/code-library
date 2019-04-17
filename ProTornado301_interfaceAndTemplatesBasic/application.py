#===============================================================================
# 应用程序与路由
#===============================================================================
import tornado.web
import config
from views import index

class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            (r'/', index.IndexHandler),
            # 模板渲染并返回给客户端
            (r'/home', index.HomeHandler),
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































