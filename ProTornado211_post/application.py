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
            
            # POST
            (r'/register', index.RegisterHandler)
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































