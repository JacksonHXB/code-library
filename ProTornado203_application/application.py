
import tornado.web
from views import index
import config

# 应用
class Application(tornado.web.Application):
    # 路由
    def __init__(self):
        handlers = [
            (r'/', index.IndexHandler),
            (r'/home', index.HomeHandler)      
        ]
        # 向父类Application传递处理类及配置文件
        super(Application,self).__init__(handlers,**config.settings)
        









































































































