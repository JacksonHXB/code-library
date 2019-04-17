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
            # 提取url的特定部分的url的设置,\w是匹配一个字母，+至少一个
            (r'/jackson/(\w+)/(\w+)/(\w+)', index.SpliteUrlHandler1)
            # 提取url的特定部分方式二:可以打乱接收顺序(不常用)
            (r'/hxb/(?P<p1>\w+)/(?P<p3>\w+)/(?P<p2>\w+)', index.SpliteUrlHandler2)
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































