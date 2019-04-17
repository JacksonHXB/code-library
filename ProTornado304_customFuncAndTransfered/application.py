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
            
            # 自定义函数
            (r'/function', index.FuncHandler),
            
            # 转义
            (r'/trans', index.TransHandler)
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































