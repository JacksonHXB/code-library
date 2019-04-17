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
            
            # Request对象
            # http://localhost:8000/getReqPorperties?a=1&b=2&c=3
            (r'/getReqPorperties', index.ReqPropertiesHandler),
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































