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
            # 反向解析,name属性标识反向解析
            tornado.web.url(r'/fejijefi', index.HxbHandler, {"param1":"value1", "param2":"value2"}, name="demo"),
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































