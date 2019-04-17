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
            
            # GET传递参数,当参数不一样时
            (r'/transfer1', index.TransferHandler1),
            
            # GET传递参数,当传递的参数中有相同的参数名时
            (r'/transfer2', index.TransferHandler2)
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































