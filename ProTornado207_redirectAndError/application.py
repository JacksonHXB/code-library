
import tornado.web
import config
from views import index
class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            (r'/', index.IndexHandler),
            # 重定向
            (r'/index', index.RedirectHandler),
            # 错误处理
            (r'/iserror', index.ErrorHandler),
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































