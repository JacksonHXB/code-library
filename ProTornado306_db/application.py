#===============================================================================
# 应用程序与路由
#===============================================================================

import tornado.web
import config
import os
from views import index
from mysql import MySQL

class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            # 展示所有学生
            (r'/students', index.StudentsHandler),      
                    
                    
            # 默认主页
            (r'/(.*)$', tornado.web.StaticFileHandler, {"path":os.path.join(config.BASE_DIRS, "static/html"),"default_filename":"index.html"})
        ]
        super(Application,self).__init__(handlers,**config.settings)
        # 添加MYSQL
        self.db = MySQL(config.mysql["host"], config.mysql["user"], config.mysql["password"], config.mysql["dbName"])





































































































