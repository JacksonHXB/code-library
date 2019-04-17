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
            
            # 上传文件
            (r'/upfile', index.UpFileHandler),
            
            # write
            (r'/write', index.WriteHandler)
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































