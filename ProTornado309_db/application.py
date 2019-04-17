#===============================================================================
# 应用程序与路由
#===============================================================================

import tornado.web
import config
import os
from views import index

class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            # 添加学生
            (r'/addStu', index.AddStuHandler),      
                    
                    
            # 默认主页
            (r'/(.*)$', tornado.web.StaticFileHandler, {"path":os.path.join(config.BASE_DIRS, "static/html"),"default_filename":"index.html"})
        ]
        super(Application,self).__init__(handlers,**config.settings)





































































































