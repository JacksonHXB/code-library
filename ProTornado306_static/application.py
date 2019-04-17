#===============================================================================
# 应用程序与路由
#===============================================================================

import tornado.web
import config
import os

class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            # 这个一般没有
#             (r'/index', index.IndexHandler),

            # StaticFileHandler，注意要放在所有路由的最下面
            (r'/(.*)$', tornado.web.StaticFileHandler, {"path":os.path.join(config.BASE_DIRS, "static/html"),"default_filename":"index.html"})
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































